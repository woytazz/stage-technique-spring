package pl.technique.stage.account.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import pl.technique.stage.entity.Admin;
import pl.technique.stage.exception.AccountNotFoundException;
import pl.technique.stage.exception.UpdateException;
import pl.technique.stage.util.hash.HashGenerator;

@Repository
public class AdminUpdateRepositoryImpl implements AdminUpdateRepository {
    private final AdminRepository repository;
    private final HashGenerator hashGenerator;

    @Lazy
    @Autowired
    public AdminUpdateRepositoryImpl(AdminRepository repository, HashGenerator hashGenerator) {
        this.repository = repository;
        this.hashGenerator = hashGenerator;
    }

    @Override
    public void updateAdmin(String login, Admin admin, String ETag) {
        Admin dbAdmin = repository.findByLogin(login)
                .orElseThrow(AccountNotFoundException::new);

        if (ETag.equals(hashGenerator.generateHMAC(dbAdmin.getLogin(), dbAdmin.getVersion()))) {
            dbAdmin.setName(admin.getName());
            dbAdmin.setSurname(admin.getSurname());
            dbAdmin.setPhoneNumber(admin.getPhoneNumber());

            repository.save(dbAdmin);
        } else {
            throw new UpdateException();
        }
    }
}
