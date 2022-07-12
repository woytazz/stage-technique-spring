package pl.technique.stage.account.service;

import pl.technique.stage.entity.Admin;

import java.util.List;

public interface AdminService {
    void createAdmin(Admin admin);

    Admin readAdminByLogin(String login);

    // TODO change on paging
    List<Admin> readAllAdmin();
}
