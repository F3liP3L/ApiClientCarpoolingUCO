package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class DriverDTO {
    private UUID id;
    private String licenseNumber;
    private AuthorizedCategoryDTO authorizedCategory;
    private CustomerDTO user;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
    }

    public DriverDTO(UUID id, String licenseNumber, AuthorizedCategoryDTO authorizedCategory, CustomerDTO user) {
        super();
        setId(id);
        setLicenseNumber(licenseNumber);
        setAuthorizedCategory(authorizedCategory);
        setUser(user);
    }

    public DriverDTO() {
        super();
        setId(UtilUUID.getDefaultUUID(id));
        setLicenseNumber(UtilText.EMPTY);
        setAuthorizedCategory(AuthorizedCategoryDTO.createNewAuthorizedCategory());
        setUser(CustomerDTO.create());
    }

    public static DriverDTO createNewDriver() {
        return new DriverDTO();
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = UtilText.getUtilText().trim(licenseNumber);
    }

    public AuthorizedCategoryDTO getAuthorizedCategory() {
        return authorizedCategory;
    }

    public void setAuthorizedCategory(AuthorizedCategoryDTO authorizedCategory) {
        this.authorizedCategory = UtilObject.getUtilObject().getDefaultIsNull(authorizedCategory,
                AuthorizedCategoryDTO.createNewAuthorizedCategory());
    }

    public CustomerDTO getUser() {
        return user;
    }

    public void setUser(CustomerDTO user) {
        this.user = UtilObject.getUtilObject().getDefaultIsNull(user, CustomerDTO.create());
    }
}
