package co.edu.uco.carpooling.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class UserEntity {
    @Id
    private UUID id;
    private String dni;
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private int phone;
    private String companyEmail;
}
