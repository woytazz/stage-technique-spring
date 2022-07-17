package pl.technique.stage.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.technique.stage.entity.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByLoginAndConfirmedTrueAndActiveTrue(String login);
}
