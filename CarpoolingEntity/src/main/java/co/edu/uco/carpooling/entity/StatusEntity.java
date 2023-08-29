package co.edu.uco.carpooling.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class StatusEntity {
    @Id
    private UUID id;
    private String status;
}
