package pl.technique.stage.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.technique.stage.account.repository.CompanyRepository;
import pl.technique.stage.entity.Company;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createCompany(Company company) {
        // TODO hash password
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
