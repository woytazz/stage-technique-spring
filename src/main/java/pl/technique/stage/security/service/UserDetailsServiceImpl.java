package pl.technique.stage.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.technique.stage.entity.Account;
import pl.technique.stage.security.repository.AccountRepository;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final String EXCEPTION_MESSAGE = "Bad username";
    private final AccountRepository repository;

    @Autowired
    public UserDetailsServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = repository.findByLoginAndConfirmedTrueAndActiveTrue(username)
                .orElseThrow(() -> new UsernameNotFoundException(EXCEPTION_MESSAGE));

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(account.getRole()));

        return new User(account.getLogin(), account.getPassword(), authorities);
    }
}
