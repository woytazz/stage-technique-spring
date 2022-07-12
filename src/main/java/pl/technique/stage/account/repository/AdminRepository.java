package pl.technique.stage.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.technique.stage.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
