package co.edu.uco.carpooling.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "vehicle")
public class VehicleEntity {
    @Column(name = "id")
    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "driver")
    private DriverEntity owner;
    @Column(name = "plate")
    private String plate;
    @Column(name = "quota")
    private int capacity;
}
