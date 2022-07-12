package pl.technique.stage.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.technique.stage.account.repository.ClientRepository;
import pl.technique.stage.entity.Client;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository repository;

    @Autowired
    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createClient(Client client) {
        // TODO hash password
        repository.save(client);
    }

    @Override
    public Client readClientByLogin(String login) {
        // TODO Throw exc
        return repository.findByLogin(login).orElseThrow();
    }

    @Override
    public List<Client> readAllClient() {
        return repository.findAll();
    }
}
