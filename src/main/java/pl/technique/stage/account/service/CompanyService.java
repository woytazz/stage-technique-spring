package pl.technique.stage.account.service;

import pl.technique.stage.entity.Company;

import java.util.List;

public interface CompanyService {
    void createCompany(Company company);

    Company readCompanyByLogin(String login);

    Company readCompanyByCompanyName(String name);

    // TODO change on paging
    List<Company> readAllCompany();
}
