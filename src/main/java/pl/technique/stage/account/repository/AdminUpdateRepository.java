package pl.technique.stage.account.repository;

import pl.technique.stage.entity.Admin;

public interface AdminUpdateRepository {
    void updateAdmin(String login, Admin admin, String ETag);
}
