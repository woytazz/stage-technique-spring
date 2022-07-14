package pl.technique.stage.account.mapper;

import org.springframework.stereotype.Component;
import pl.technique.stage.account.dto.get.ClientGetDto;
import pl.technique.stage.account.dto.patch.ClientPatchDto;
import pl.technique.stage.account.dto.post.ClientPostDto;
import pl.technique.stage.entity.Client;

@Component
public class ClientMapperImpl implements ClientMapper {
    @Override
    public ClientGetDto convertToClientGetDto(Client client) {
        if (client == null) {
            return null;
        }

        ClientGetDto clientGetDto = new ClientGetDto();

        // Account class fields
        clientGetDto.setLogin(client.getLogin());
        clientGetDto.setConfirmed(client.isConfirmed());
        clientGetDto.setActive(client.isActive());
        clientGetDto.setName(client.getName());
        clientGetDto.setSurname(client.getSurname());
        clientGetDto.setEmail(client.getEmail());
        clientGetDto.setPhoneNumber(client.getPhoneNumber());

        return clientGetDto;
    }

    @Override
    public Client convertToClient(ClientPostDto clientPostDto) {
        if (clientPostDto == null) {
            return null;
        }

        Client client = new Client();

        // Account class fields
        client.setLogin(clientPostDto.getLogin());
        client.setPassword(clientPostDto.getPassword());
        client.setName(clientPostDto.getName());
        client.setSurname(clientPostDto.getSurname());
        client.setEmail(clientPostDto.getEmail());
        client.setPhoneNumber(clientPostDto.getPhoneNumber());

        return client;
    }

    @Override
    public Client convertToClient(ClientPatchDto clientPatchDto) {
        if (clientPatchDto == null) {
            return null;
        }

        Client client = new Client();

        // Account class fields
        client.setName(clientPatchDto.getName());
        client.setSurname(clientPatchDto.getSurname());
        client.setPhoneNumber(clientPatchDto.getPhoneNumber());

        return client;
    }
}
