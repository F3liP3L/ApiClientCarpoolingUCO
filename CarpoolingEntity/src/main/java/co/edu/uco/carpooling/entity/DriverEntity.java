package co.edu.uco.carpooling.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
public class DriverEntity extends UserEntity{
    private String licenseNumber;
    @ManyToOne
    private AuthorizedCategoryEntity authorizedCategory;
    @Id
    private UUID id;

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public AuthorizedCategoryEntity getAuthorizedCategory() {
        return authorizedCategory;
    }

    public void setAuthorizedCategory(AuthorizedCategoryEntity authorizedCategory) {
        this.authorizedCategory = authorizedCategory;
    }
}
