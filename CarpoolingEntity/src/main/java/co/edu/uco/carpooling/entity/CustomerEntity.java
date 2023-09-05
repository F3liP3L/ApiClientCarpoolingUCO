package co.edu.uco.carpooling.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @Column(unique = true)
    private UUID id;
    @Column(name = "dni")
    private String dni;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "first_surname")
    private String firstSurname;
    @Column(name = "second_surname")
    private String secondSurname;
    @Column(name = "password_user")
    private String password;
    @Column(name = "email")
    private String companyEmail;
    @Column(name = "phone")
    private int phone;
    @Column(name = "rol")
    private int rol;
}
