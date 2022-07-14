package pl.technique.stage.account.service;

import pl.technique.stage.entity.Company;

import java.util.List;

public interface CompanyService {
    void createCompany(Company company);

    Company readCompanyByLogin(String login);

    Company readCompanyByCompanyName(String name);

    List<Company> readAllCompany();

    void updateCompany(String login, Company company, String ETag);
}
