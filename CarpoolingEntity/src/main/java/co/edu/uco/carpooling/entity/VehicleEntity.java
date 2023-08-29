package co.edu.uco.carpooling.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class VehicleEntity {
    @Id
    private UUID id;
    private String plate;
    private int capacity;
    @ManyToOne
    private DriverEntity owner;
}
