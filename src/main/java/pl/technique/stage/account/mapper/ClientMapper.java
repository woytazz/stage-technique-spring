package pl.technique.stage.account.mapper;

import pl.technique.stage.account.dto.get.ClientGetDto;
import pl.technique.stage.account.dto.post.ClientPostDto;
import pl.technique.stage.entity.Client;

public interface ClientMapper {
    ClientGetDto convertToClientGetDto(Client client);

    Client convertToClient(ClientPostDto clientPostDto);
}
