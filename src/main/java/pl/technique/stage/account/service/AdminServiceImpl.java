package pl.technique.stage.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.technique.stage.account.repository.AdminRepository;
import pl.technique.stage.entity.Admin;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository repository;

    @Autowired
    public AdminServiceImpl(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createAdmin(Admin admin) {
        // TODO hash password
        repository.save(admin);
    }

    @Override
    public Admin readAdminByLogin(String login) {
        //TODO throw exc
        return repository.findByLogin(login).orElseThrow();
    }

    @Override
    public List<Admin> readAllAdmin() {
        return repository.findAll();
    }
}
