package pl.technique.stage.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import static pl.technique.stage.entity.Account.CONSTRAINT_EMAIL_UNIQUE;
import static pl.technique.stage.entity.Account.CONSTRAINT_LOGIN_UNIQUE;

@Entity
@Table(
        name = "account",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "login", name = CONSTRAINT_LOGIN_UNIQUE),
                @UniqueConstraint(columnNames = "email", name = CONSTRAINT_EMAIL_UNIQUE)
        })
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account extends AbstractEntity {
    public static final String CONSTRAINT_LOGIN_UNIQUE = "account_login_unique";
    public static final String CONSTRAINT_EMAIL_UNIQUE = "account_email_unique";

    @Basic(optional = false)
    @Column(name = "login")
    @Size(min = 4, max = 16)
    @Getter
    @Setter
    private String login;

    @Basic(optional = false)
    @Column(name = "password")
    @Size(min = 8, max = 64)
    @Getter
    @Setter
    private String password;

    @Basic(optional = false)
    @Column(name = "confirmed")
    @Getter
    @Setter
    private boolean confirmed = false;

    @Basic(optional = false)
    @Column(name = "active")
    @Getter
    @Setter
    private boolean active = true;

    @Basic(optional = false)
    @Size(min = 2, max = 64)
    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Basic(optional = false)
    @Size(min = 2, max = 64)
    @Column(name = "surname")
    @Getter
    @Setter
    private String surname;

    @Basic(optional = false)
    @Size(min = 1, max = 256)
    @Email
    @Column(name = "email")
    @Getter
    @Setter
    private String email;

    @Basic(optional = false)
    @Size(min = 9, max = 9)
    @Column(name = "phone_number")
    @Getter
    @Setter
    private String phoneNumber;

    public abstract String getRole();
}
