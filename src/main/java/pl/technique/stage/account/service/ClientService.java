package pl.technique.stage.account.service;

import pl.technique.stage.entity.Client;

import java.util.List;

public interface ClientService {
    void createClient(Client client);

    Client readClientByLogin(String login);

    // TODO change on paging
    List<Client> readAllClient();

    void updateClient(String login, Client client, String ETag);
}
