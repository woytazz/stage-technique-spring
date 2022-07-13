package pl.technique.stage.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "company")
@NoArgsConstructor
public class Company extends Account {
    @Basic(optional = false)
    @Column(name = "role")
    private final String role = "COMPANY";

    @Basic(optional = false)
    @Size(min = 2, max = 32)
    @Column(name = "company_name", unique = true)
    @Getter
    @Setter
    private String companyName;

    @Basic(optional = false)
    @Size(min = 10, max = 10)
    @Column(name = "nip", updatable = false, unique = true)
    @Getter
    @Setter
    private String nip;

    @Basic(optional = false)
    @Column(name = "address", unique = true)
    @Size(min = 4, max = 100)
    @Getter
    @Setter
    private String address;

    @Basic(optional = false)
    @Column(name = "description")
    @Getter
    @Setter
    private String description;

    @Basic(optional = false)
    @Column(name = "logo_url")
    @Getter
    @Setter
    private String logoUrl;

    @Override
    public String getRole() {
        return role;
    }
}
