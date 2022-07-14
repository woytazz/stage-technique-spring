package pl.technique.stage.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.technique.stage.account.repository.CompanyRepository;
import pl.technique.stage.entity.Company;
import pl.technique.stage.exception.AccountNotFoundException;
import pl.technique.stage.util.hash.HashGenerator;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;
    private final HashGenerator hashGenerator;

    @Autowired
    public CompanyServiceImpl(CompanyRepository repository, HashGenerator hashGenerator) {
        this.repository = repository;
        this.hashGenerator = hashGenerator;
    }

    @Override
    public void createCompany(Company company) {
        company.setPassword(hashGenerator.generateHash(company.getPassword()));
        repository.save(company);
    }

    @Override
    public Company readCompanyByLogin(String login) {
        return repository.findByLogin(login)
                .orElseThrow(AccountNotFoundException::new);
    }

    @Override
    public Company readCompanyByCompanyName(String name) {
        return repository.findByCompanyName(name)
                .orElseThrow(AccountNotFoundException::new);
    }

    @Override
    public List<Company> readAllCompany() {
        return repository.findAll();
    }

    @Override
    public void updateCompany(String login, Company company, String ETag) {
        repository.updateCompany(login, company, ETag);
    }
}
