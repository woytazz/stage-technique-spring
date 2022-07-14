package pl.technique.stage.account.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import pl.technique.stage.entity.Company;
import pl.technique.stage.exception.AccountNotFoundException;
import pl.technique.stage.exception.UpdateException;
import pl.technique.stage.util.hash.HashGenerator;

@Repository
public class CompanyUpdateRepositoryImpl implements CompanyUpdateRepository {
    private final CompanyRepository repository;
    private final HashGenerator hashGenerator;

    @Lazy
    @Autowired
    public CompanyUpdateRepositoryImpl(CompanyRepository repository, HashGenerator hashGenerator) {
        this.repository = repository;
        this.hashGenerator = hashGenerator;
    }

    @Override
    public void updateCompany(String login, Company company, String ETag) {
        Company dbCompany = repository.findByLogin(login)
                .orElseThrow(AccountNotFoundException::new);

        if (ETag.equals(hashGenerator.generateHMAC(dbCompany.getLogin(), dbCompany.getVersion()))) {
            dbCompany.setName(company.getName());
            dbCompany.setSurname(company.getSurname());
            dbCompany.setPhoneNumber(company.getPhoneNumber());
            dbCompany.setAddress(company.getAddress());
            dbCompany.setDescription(company.getDescription());
            dbCompany.setLogoUrl(company.getLogoUrl());

            repository.save(dbCompany);
        } else {
            throw new UpdateException();
        }
    }
}
