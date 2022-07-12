package pl.technique.stage.account.mapper;

import org.springframework.stereotype.Component;
import pl.technique.stage.account.dto.get.CompanyGetDto;
import pl.technique.stage.account.dto.post.CompanyPostDto;
import pl.technique.stage.entity.Company;

@Component
public class CompanyMapperImpl implements CompanyMapper {
    @Override
    public CompanyGetDto convertToCompanyGetDto(Company company) {
        if (company == null) {
            return null;
        }

        CompanyGetDto companyGetDto = new CompanyGetDto();

        // Account class fields
        companyGetDto.setLogin(company.getLogin());
        companyGetDto.setConfirmed(company.isConfirmed());
        companyGetDto.setActive(company.isActive());
        companyGetDto.setName(company.getName());
        companyGetDto.setSurname(company.getSurname());
        companyGetDto.setEmail(company.getEmail());
        companyGetDto.setPhoneNumber(company.getPhoneNumber());

        // Company class fields
        companyGetDto.setCompanyName(company.getCompanyName());
        companyGetDto.setNip(company.getNip());
        companyGetDto.setAddress(company.getAddress());
        companyGetDto.setDescription(company.getDescription());
        companyGetDto.setLogoUrl(company.getLogoUrl());

        return companyGetDto;
    }

    @Override
    public Company convertToCompany(CompanyPostDto companyPostDto) {
        if (companyPostDto == null) {
            return null;
        }

        Company company = new Company();

        // Account class fields
        company.setLogin(companyPostDto.getLogin());
        company.setPassword(companyPostDto.getPassword());
        company.setName(companyPostDto.getName());
        company.setSurname(companyPostDto.getSurname());
        company.setEmail(companyPostDto.getEmail());
        company.setPhoneNumber(companyPostDto.getPhoneNumber());

        // Company class fields
        company.setCompanyName(companyPostDto.getCompanyName());
        company.setNip(companyPostDto.getNip());
        company.setAddress(companyPostDto.getAddress());
        company.setDescription(companyPostDto.getDescription());
        company.setLogoUrl(companyPostDto.getLogoUrl());

        return company;
    }
}
