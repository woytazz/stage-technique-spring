package pl.technique.stage.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.technique.stage.entity.Company;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long>, CompanyUpdateRepository {
    Optional<Company> findByLogin(String login);

    Optional<Company> findByCompanyName(String companyName);
}
