package co.edu.uco.carpooling.service.domain;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilText.EMPTY;

public class DriverDomain {

    private UUID id;
    private String licenseNumber;
    private AuthorizedCategoryDomain authorizedCategory;
    private CustomerDomain user;

    public DriverDomain(UUID id, String licenseNumber, AuthorizedCategoryDomain authorizedCategory) {
        super();
        setId(id);
        setLicenseNumber(licenseNumber);
        setAuthorizedCategory(authorizedCategory);
        setUser(user);
    }

    public DriverDomain() {
        super();/*
        setId(UtilUUID.getNewUUID());
        setLicenseNumber(EMPTY);
        setAuthorizedCategory(AuthorizedCategoryDomain.createNewAuthorizedCategory());
        setUser(CustomerDomain.build());*/
    }

    public static DriverDomain createNewDriver() {
        return new DriverDomain();
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = UtilText.getUtilText().trim(licenseNumber);
    }

    public void setAuthorizedCategory(AuthorizedCategoryDomain authorizedCategory) {
        this.authorizedCategory = UtilObject.getUtilObject().getDefaultIsNull(authorizedCategory,
                AuthorizedCategoryDomain.createNewAuthorizedCategory());
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public AuthorizedCategoryDomain getAuthorizedCategory() {
        return authorizedCategory;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
    }

    public CustomerDomain getUser() {
        return user;
    }

    public void setUser(CustomerDomain user) {
        this.user = UtilObject.getUtilObject().getDefaultIsNull(user, CustomerDomain.build());
    }
}
