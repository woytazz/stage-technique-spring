package pl.technique.stage.account.mapper;

import pl.technique.stage.account.dto.get.AdminGetDto;
import pl.technique.stage.account.dto.patch.AdminPatchDto;
import pl.technique.stage.account.dto.post.AdminPostDto;
import pl.technique.stage.entity.Admin;

public interface AdminMapper {
    AdminGetDto convertToAdminGetDto(Admin admin);

    Admin convertToAdmin(AdminPostDto adminPostDto);

    Admin convertToAdmin(AdminPatchDto adminPatchDto);
}
