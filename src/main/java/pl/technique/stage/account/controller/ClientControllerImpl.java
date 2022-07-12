package pl.technique.stage.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.technique.stage.account.dto.get.ClientGetDto;
import pl.technique.stage.account.dto.post.ClientPostDto;
import pl.technique.stage.account.mapper.ClientMapper;
import pl.technique.stage.account.service.ClientService;

import java.util.List;

@RestController
public class ClientControllerImpl implements ClientController {
    private final ClientService service;
    private final ClientMapper mapper;

    @Autowired
    public ClientControllerImpl(ClientService service, ClientMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }


    @Override
    public ResponseEntity<Void> postClient(ClientPostDto clientPostDto) {
        service.createClient(mapper.convertToClient(clientPostDto));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @Override
    public ResponseEntity<ClientGetDto> getClientByLogin(String login) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mapper.convertToClientGetDto(service.readClientByLogin(login)));
    }

    @Override
    public ResponseEntity<List<ClientGetDto>> getAllClient() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.readAllClient()
                        .stream()
                        .map(mapper::convertToClientGetDto)
                        .toList()
                );
    }
}
