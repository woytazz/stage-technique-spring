package pl.technique.stage.account.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.technique.stage.account.dto.get.AdminGetDto;
import pl.technique.stage.account.dto.patch.AdminPatchDto;
import pl.technique.stage.account.dto.post.AdminPostDto;

import java.util.List;

@RequestMapping("/admin")
public interface AdminController {
    @PostMapping("/save")
    ResponseEntity<Void> postAdmin(@RequestBody AdminPostDto adminPostDto);

    @GetMapping("/{login}")
    ResponseEntity<AdminGetDto> getAdminByLogin(@PathVariable String login);

    @GetMapping
    ResponseEntity<List<AdminGetDto>> getAllAdmin();

    @PatchMapping
    ResponseEntity<Void> patchAdmin(@RequestBody AdminPatchDto adminPatchDto);
}
