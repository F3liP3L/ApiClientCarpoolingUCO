package co.edu.uco.carpooling.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "route")
public class RouteEntity {
    @Id
    private UUID id;
    private int routeCapacity;
    @ElementCollection
    @CollectionTable(name = "point_of_interest", joinColumns = @JoinColumn(name = "route"))
    private List<String> pointOfInterest;
    private LocalDateTime routeTime;

}
