package pl.technique.stage.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.technique.stage.entity.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByLogin(String login);
}
