package pl.technique.stage.account.service;

import pl.technique.stage.entity.Admin;

import java.util.List;

public interface AdminService {
    void createAdmin(Admin admin);

    // TODO delete
    Admin readAdminById(long id);

    // TODO change on paging
    List<Admin> readAllAdmin();
}
