package co.edu.uco.carpooling.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "driver_per_vehicle")
public class DriverPerVehicleEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "driver")
    private DriverEntity driver;
    @ManyToOne
    @JoinColumn(name = "vehicle")
    private VehicleEntity vehicle;
    @Column(name = "state")
    private boolean driverPerVehicleStatus;
}
