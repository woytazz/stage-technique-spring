package pl.technique.stage.account.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.technique.stage.account.dto.get.CompanyGetDto;
import pl.technique.stage.account.dto.post.CompanyPostDto;

import java.util.List;

@RequestMapping("/company")
public interface CompanyController {
    @PostMapping("/save")
    ResponseEntity<Void> postCompany(@RequestBody CompanyPostDto companyPostDto);

    @GetMapping("/{login}")
    ResponseEntity<CompanyGetDto> getCompanyByLogin(@PathVariable String login);

    @GetMapping("/company/{name}")
    ResponseEntity<CompanyGetDto> getCompanyByCompanyName(@PathVariable String name);

    @GetMapping
    ResponseEntity<List<CompanyGetDto>> getAllCompany();
}
