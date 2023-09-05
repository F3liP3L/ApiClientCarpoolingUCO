package co.edu.uco.carpooling.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "authorized_category")
public class AuthorizedCategoryEntity {
    @Id
    private UUID id;
    @Column(name = "category")
    private String category;
    @Column(name = "expiration")
    private String expiration;
}
