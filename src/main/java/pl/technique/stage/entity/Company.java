package pl.technique.stage.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

import static pl.technique.stage.entity.Company.*;

@Entity
@Table(
        name = "company",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "company_name", name = CONSTRAINT_COMPANY_NAME_UNIQUE),
                @UniqueConstraint(columnNames = "nip", name = CONSTRAINT_NIP_UNIQUE),
                @UniqueConstraint(columnNames = "address", name = CONSTRAINT_ADDRESS_UNIQUE)
        })
@NoArgsConstructor
public class Company extends Account {
    public static final String CONSTRAINT_COMPANY_NAME_UNIQUE = "company_name_unique";
    public static final String CONSTRAINT_NIP_UNIQUE = "company_nip_unique";
    public static final String CONSTRAINT_ADDRESS_UNIQUE = "company_address_unique";

    @Basic(optional = false)
    @Column(name = "role")
    private final String role = "COMPANY";

    @Basic(optional = false)
    @Size(min = 2, max = 32)
    @Column(name = "company_name")
    @Getter
    @Setter
    private String companyName;

    @Basic(optional = false)
    @Size(min = 10, max = 10)
    @Column(name = "nip", updatable = false)
    @Getter
    @Setter
    private String nip;

    @Basic(optional = false)
    @Column(name = "address")
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
