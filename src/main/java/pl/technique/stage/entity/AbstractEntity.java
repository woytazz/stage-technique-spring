package pl.technique.stage.entity;

import lombok.Getter;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity {
    @Basic(optional = false)
    @Column(name = "id", updatable = false, unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Basic(optional = false)
    @Column(name = "version")
    @Version
    @Getter
    private Long version;
}
