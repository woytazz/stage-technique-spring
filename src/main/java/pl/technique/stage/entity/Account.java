package pl.technique.stage.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class Account extends AbstractEntity {
    @Basic(optional = false)
    @Column(name = "login", unique = true)
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
    @Column(name = "email", unique = true)
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
