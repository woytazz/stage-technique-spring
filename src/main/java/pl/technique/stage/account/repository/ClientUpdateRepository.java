package pl.technique.stage.account.repository;

import pl.technique.stage.entity.Client;

public interface ClientUpdateRepository {
    void updateClient(String login, Client client, String ETag);
}
