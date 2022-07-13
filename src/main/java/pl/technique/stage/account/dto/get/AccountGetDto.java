package pl.technique.stage.account.dto.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AccountGetDto {
    @JsonProperty("login")
    private String login;

    @JsonProperty("confirmed")
    private boolean confirmed;

    @JsonProperty("active")
    private boolean active;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phoneNumber")
    private String phoneNumber;
}
