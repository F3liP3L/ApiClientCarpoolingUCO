package co.edu.uco.carpooling.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @Column(unique = true)
    private UUID id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}
