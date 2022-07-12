package pl.technique.stage.account.dto.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AccountPostDto {
    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
}
