package pl.technique.stage.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.technique.stage.account.repository.ClientRepository;
import pl.technique.stage.entity.Client;
import pl.technique.stage.exception.AccountNotFoundException;
import pl.technique.stage.util.hash.HashGenerator;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository repository;
    private final HashGenerator hashGenerator;

    @Autowired
    public ClientServiceImpl(ClientRepository repository, HashGenerator hashGenerator) {
        this.repository = repository;
        this.hashGenerator = hashGenerator;
    }

    @Override
    public void createClient(Client client) {
        client.setPassword(hashGenerator.generateHash(client.getPassword()));
        repository.save(client);
    }

    @Override
    public Client readClientByLogin(String login) {
        return repository.findByLogin(login)
                .orElseThrow(AccountNotFoundException::new);
    }

    @Override
    public List<Client> readAllClient() {
        return repository.findAll();
    }

    @Override
    public void updateClient(String login, Client client, String ETag) {
        repository.updateClient(login, client, ETag);
    }
}
