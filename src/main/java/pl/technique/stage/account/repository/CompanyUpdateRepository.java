package pl.technique.stage.account.repository;

import pl.technique.stage.entity.Company;

public interface CompanyUpdateRepository {
    void updateCompany(String login, Company company, String ETag);
}
