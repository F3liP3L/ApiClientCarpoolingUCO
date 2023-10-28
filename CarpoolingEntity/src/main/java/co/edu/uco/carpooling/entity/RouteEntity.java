package co.edu.uco.carpooling.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "route")
public class RouteEntity {
    @Id
    private UUID id;
    private int routeCapacity;
    @ManyToOne
    @JoinColumn(name = "driver_vehicle_id")
    private DriverPerVehicleEntity driverVehicle;
    @ElementCollection
    @CollectionTable(name = "point_of_interest", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "pointOfInterest")
    private List<String> pointOfInterest;
    @Lob
    private String positions;
    private LocalDateTime routeTime;
    private String status;
}
