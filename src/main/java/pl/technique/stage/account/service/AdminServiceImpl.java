package pl.technique.stage.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.technique.stage.account.repository.AdminRepository;
import pl.technique.stage.entity.Admin;
import pl.technique.stage.exception.AccountNotFoundException;
import pl.technique.stage.exception.UpdateException;
import pl.technique.stage.util.hash.HashGenerator;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final HashGenerator hashGenerator;

    @Autowired
    public AdminServiceImpl(AdminRepository repository, PasswordEncoder passwordEncoder, HashGenerator hashGenerator) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.hashGenerator = hashGenerator;
    }

    @Override
    public void createAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        repository.save(admin);
    }

    @Override
    public Admin readAdminByLogin(String login) {
        return repository.findByLogin(login)
                .orElseThrow(AccountNotFoundException::new);
    }

    @Override
    public List<Admin> readAllAdmin() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public void updateAdmin(String login, Admin admin, String ETag) {
        Admin dbAdmin = repository.findByLogin(login)
                .orElseThrow(AccountNotFoundException::new);

        if (ETag.equals(hashGenerator.generateHMAC(dbAdmin.getLogin(), dbAdmin.getVersion()))) {
            dbAdmin.setName(admin.getName());
            dbAdmin.setSurname(admin.getSurname());
            dbAdmin.setPhoneNumber(admin.getPhoneNumber());

            repository.save(dbAdmin);
        } else {
            throw new UpdateException();
        }
    }
}
