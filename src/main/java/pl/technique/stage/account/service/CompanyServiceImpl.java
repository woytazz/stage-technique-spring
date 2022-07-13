package pl.technique.stage.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.technique.stage.account.repository.CompanyRepository;
import pl.technique.stage.entity.Company;
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
        // TODO throw exc
        return repository.findByLogin(login).orElseThrow();
    }

    @Override
    public Company readCompanyByCompanyName(String name) {
        // TODO throw exc
        return repository.findByCompanyName(name).orElseThrow();
    }

    @Override
    public List<Company> readAllCompany() {
        return repository.findAll();
    }
}
