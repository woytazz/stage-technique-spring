package pl.technique.stage.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.technique.stage.account.dto.get.AdminGetDto;
import pl.technique.stage.account.dto.post.AdminPostDto;
import pl.technique.stage.account.mapper.AdminMapper;
import pl.technique.stage.account.service.AdminService;

import java.util.List;

@RestController
public class AdminControllerImpl implements AdminController {
    private final AdminService service;
    private final AdminMapper mapper;

    @Autowired
    public AdminControllerImpl(AdminService service, AdminMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<Void> postAdmin(AdminPostDto adminPostDto) {
        service.createAdmin(mapper.convertToAdmin(adminPostDto));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @Override
    public ResponseEntity<AdminGetDto> getAdminById(long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mapper.convertToAdminGetDto(service.readAdminById(id)));
    }

    @Override
    public ResponseEntity<List<AdminGetDto>> getAllAdmin() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.readAllAdmin()
                        .stream()
                        .map(mapper::convertToAdminGetDto)
                        .toList()
                );
    }
}
