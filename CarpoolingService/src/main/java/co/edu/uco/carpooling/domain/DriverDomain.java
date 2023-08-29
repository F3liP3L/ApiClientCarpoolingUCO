package co.edu.uco.carpooling.domain;

import co.edu.uco.carpooling.dto.AuthorizedCategoryDTO;
import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilText;
public class DriverDomain extends UserDomain {
    private String licenseNumber;
    private AuthorizedCategoryDTO authorizedCategory;

    public DriverDomain(String licenseNumber, AuthorizedCategoryDTO authorizedCategory) {
        super();
        setLicenseNumber(licenseNumber);
        setAuthorizedCategory(authorizedCategory);
    }

    public DriverDomain() {
        super();
        setLicenseNumber(UtilText.EMPTY);
        setAuthorizedCategory(AuthorizedCategoryDTO.createNewAuthorizedCategory());
    }

    public static DriverDomain createNewDriver() {
        return new DriverDomain();
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
