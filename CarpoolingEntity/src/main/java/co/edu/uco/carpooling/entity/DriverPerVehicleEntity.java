package co.edu.uco.carpooling.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class DriverPerVehicleEntity {
    @Id
    private UUID id;
    @ManyToOne
    private DriverEntity driver;
    @ManyToOne
    private VehicleEntity vehicle;
    @ManyToOne
    private StatusEntity driverPerVehicleStatus;
}
