package pl.technique.stage.account.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import pl.technique.stage.entity.Client;
import pl.technique.stage.exception.AccountNotFoundException;
import pl.technique.stage.exception.UpdateException;
import pl.technique.stage.util.hash.HashGenerator;

@Repository
public class ClientUpdateRepositoryImpl implements ClientUpdateRepository {
    private final ClientRepository repository;
    private final HashGenerator hashGenerator;

    @Lazy
    @Autowired
    public ClientUpdateRepositoryImpl(ClientRepository repository, HashGenerator hashGenerator) {
        this.repository = repository;
        this.hashGenerator = hashGenerator;
    }

    @Override
    public void updateClient(String login, Client client, String ETag) {
        Client dbClient = repository.findByLogin(login)
                .orElseThrow(AccountNotFoundException::new);

        if (ETag.equals(hashGenerator.generateHMAC(dbClient.getLogin(), dbClient.getVersion()))) {
            dbClient.setName(client.getName());
            dbClient.setSurname(client.getSurname());
            dbClient.setPhoneNumber(client.getPhoneNumber());

            repository.save(dbClient);
        } else {
            throw new UpdateException();
        }
    }
}
