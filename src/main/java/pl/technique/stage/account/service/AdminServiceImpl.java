package pl.technique.stage.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.technique.stage.account.repository.AdminRepository;
import pl.technique.stage.entity.Admin;
import pl.technique.stage.exception.AccountNotFoundException;
import pl.technique.stage.util.hash.HashGenerator;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository repository;
    private final HashGenerator hashGenerator;

    @Autowired
    public AdminServiceImpl(AdminRepository repository, HashGenerator hashGenerator) {
        this.repository = repository;
        this.hashGenerator = hashGenerator;
    }

    @Override
    public void createAdmin(Admin admin) {
        admin.setPassword(hashGenerator.generateHash(admin.getPassword()));
        repository.save(admin);
    }

    @Override
    public Admin readAdminByLogin(String login) {
        return repository.findByLogin(login)
                .orElseThrow(AccountNotFoundException::new);
    }

    @Override
    public List<Admin> readAllAdmin() {
        return repository.findAll();
    }

    @Override
    public void updateAdmin(String login, Admin admin, String ETag) {
        repository.updateAdmin(login, admin, ETag);
    }
}
