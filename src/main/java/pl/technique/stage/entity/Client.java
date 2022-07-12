package pl.technique.stage.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "client")
@NoArgsConstructor
public class Client extends Account {
    @Basic(optional = false)
    @Column(name = "role")
    private final String role = "CLIENT";

    @Override
    public String getRole() {
        return role;
    }
}
