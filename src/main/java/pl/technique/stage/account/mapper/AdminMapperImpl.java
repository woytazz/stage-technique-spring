package pl.technique.stage.account.mapper;

import org.springframework.stereotype.Component;
import pl.technique.stage.account.dto.get.AdminGetDto;
import pl.technique.stage.account.dto.post.AdminPostDto;
import pl.technique.stage.entity.Admin;

@Component
public class AdminMapperImpl implements AdminMapper {
    @Override
    public AdminGetDto convertToAdminGetDto(Admin admin) {
        if (admin == null) {
            return null;
        }

        AdminGetDto adminGetDto = new AdminGetDto();

        // Account class fields
        adminGetDto.setLogin(admin.getLogin());
        adminGetDto.setConfirmed(admin.isConfirmed());
        adminGetDto.setActive(admin.isActive());
        adminGetDto.setName(admin.getName());
        adminGetDto.setSurname(admin.getSurname());
        adminGetDto.setEmail(admin.getEmail());
        adminGetDto.setPhoneNumber(admin.getPhoneNumber());

        return adminGetDto;
    }

    @Override
    public Admin convertToAdmin(AdminPostDto adminPostDto) {
        if (adminPostDto == null) {
            return null;
        }

        Admin admin = new Admin();

        // Account class fields
        admin.setLogin(adminPostDto.getLogin());
        admin.setPassword(adminPostDto.getPassword());
        admin.setName(adminPostDto.getName());
        admin.setSurname(adminPostDto.getSurname());
        admin.setEmail(adminPostDto.getEmail());
        admin.setPhoneNumber(adminPostDto.getPhoneNumber());

        return admin;
    }
}
