package pl.technique.stage.account.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.technique.stage.account.dto.get.ClientGetDto;
import pl.technique.stage.account.dto.post.ClientPostDto;

import java.util.List;

@RequestMapping("/client")
public interface ClientController {
    @PostMapping
    ResponseEntity<Void> postClient(@RequestBody ClientPostDto clientPostDto);

    @GetMapping("/{login}")
    ResponseEntity<ClientGetDto> getClientByLogin(@PathVariable String login);

    @GetMapping
    ResponseEntity<List<ClientGetDto>> getAllClient();
}
