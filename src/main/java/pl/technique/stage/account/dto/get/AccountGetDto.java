package pl.technique.stage.account.dto.get;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AccountGetDto {
    private String login;
    private boolean confirmed;
    private boolean active;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
}
