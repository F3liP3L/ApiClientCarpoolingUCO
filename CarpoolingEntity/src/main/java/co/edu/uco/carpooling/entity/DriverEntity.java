package co.edu.uco.carpooling.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "driver")
public class DriverEntity extends CustomerEntity {
    @Column(name = "license")
    private String licenseNumber;
    @ManyToOne
    @JoinColumn(name = "authorized_category")
    private AuthorizedCategoryEntity authorizedCategory;
    @Id
    @JoinColumn(name = "user")
    private UUID id;

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public UUID getId() {
        return id;
    }
}
