package co.edu.uco.carpooling.service.domain;

import co.edu.uco.carpooling.dto.AuthorizedCategoryDTO;
import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilText;
import lombok.Getter;

@Getter
public class DriverDomain extends CustomerDomain {
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

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = UtilText.getUtilText().trim(licenseNumber);
    }

    public void setAuthorizedCategory(AuthorizedCategoryDTO authorizedCategory) {
        this.authorizedCategory = UtilObject.getUtilObject().getDefaultIsNull(authorizedCategory,
                AuthorizedCategoryDTO.createNewAuthorizedCategory());
    }
}
