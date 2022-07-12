package pl.technique.stage.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "administrator")
@NoArgsConstructor
public class Admin extends Account {
    @Basic(optional = false)
    @Column(name = "role")
    private final String role = "ADMIN";

    @Override
    public String getRole() {
        return role;
    }
}
