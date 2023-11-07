package co.edu.uco.carpooling.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;


@Data
@Entity
@Table(name = "driver")
public class DriverEntity {
    @Id
    private UUID id;
    @Column(name = "license")
    private String licenseNumber;
    @ManyToOne
    @JoinColumn(name = "authorized_category")
    private AuthorizedCategoryEntity authorizedCategory;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

}
