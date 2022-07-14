package pl.technique.stage.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.technique.stage.entity.Admin;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long>, AdminUpdateRepository {
    Optional<Admin> findByLogin(String login);
}
