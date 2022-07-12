package pl.technique.stage.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.technique.stage.account.dto.get.CompanyGetDto;
import pl.technique.stage.account.dto.post.CompanyPostDto;
import pl.technique.stage.account.mapper.CompanyMapper;
import pl.technique.stage.account.service.CompanyService;

import java.util.List;

@RestController
public class CompanyControllerImpl implements CompanyController {
    private final CompanyService service;
    private final CompanyMapper mapper;

    @Autowired
    public CompanyControllerImpl(CompanyService service, CompanyMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<Void> postCompany(CompanyPostDto companyPostDto) {
        service.createCompany(mapper.convertToCompany(companyPostDto));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @Override
    public ResponseEntity<CompanyGetDto> getCompanyByLogin(String login) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mapper.convertToCompanyGetDto(service.readCompanyByLogin(login)));
    }

    @Override
    public ResponseEntity<CompanyGetDto> getCompanyByCompanyName(String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mapper.convertToCompanyGetDto(service.readCompanyByCompanyName(name)));
    }

    @Override
    public ResponseEntity<List<CompanyGetDto>> getAllCompany() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.readAllCompany()
                        .stream()
                        .map(mapper::convertToCompanyGetDto)
                        .toList()
                );
    }
}
