package pl.technique.stage.account.mapper;

import pl.technique.stage.account.dto.get.CompanyGetDto;
import pl.technique.stage.account.dto.patch.CompanyPatchDto;
import pl.technique.stage.account.dto.post.CompanyPostDto;
import pl.technique.stage.entity.Company;

public interface CompanyMapper {
    CompanyGetDto convertToCompanyGetDto(Company company);

    Company convertToCompany(CompanyPostDto companyPostDto);

    Company convertToCompany(CompanyPatchDto companyPatchDto);
}
