package pl.technique.stage.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.technique.stage.account.repository.CompanyRepository;
import pl.technique.stage.entity.Company;
import pl.technique.stage.exception.AccountNotFoundException;
import pl.technique.stage.exception.UpdateException;
import pl.technique.stage.util.hash.HashGenerator;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final HashGenerator hashGenerator;

    @Autowired
    public CompanyServiceImpl(CompanyRepository repository, PasswordEncoder passwordEncoder, HashGenerator hashGenerator) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.hashGenerator = hashGenerator;
    }

    @Override
    public void createCompany(Company company) {
        company.setPassword(passwordEncoder.encode(company.getPassword()));
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

    @Transactional
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
