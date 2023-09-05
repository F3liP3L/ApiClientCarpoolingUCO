package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilText;

public class DriverDTO extends CustomerDTO {
    private String licenseNumber;
    private AuthorizedCategoryDTO authorizedCategory;

    public DriverDTO(String licenseNumber, AuthorizedCategoryDTO authorizedCategory) {
        super();
        setLicenseNumber(licenseNumber);
        setAuthorizedCategory(authorizedCategory);
    }

    public DriverDTO() {
        super();
        setLicenseNumber(UtilText.EMPTY);
        setAuthorizedCategory(AuthorizedCategoryDTO.createNewAuthorizedCategory());
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
}
