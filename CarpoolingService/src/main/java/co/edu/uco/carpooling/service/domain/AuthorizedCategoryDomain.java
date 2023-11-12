package co.edu.uco.carpooling.service.domain;

import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;
import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilUUID.getDefaultUUID;
import static co.edu.uco.crosscutting.util.UtilUUID.getNewUUID;

@Getter
public class AuthorizedCategoryDomain {
    private UUID id;
    private String category;
    public AuthorizedCategoryDomain(UUID id, String category) {
        setId(id);
        setCategory(category);
    }

    public AuthorizedCategoryDomain() {
        setId(UtilUUID.DEFAULT_UUID);
        setCategory(UtilText.EMPTY);
    }

    public static AuthorizedCategoryDomain createNewAuthorizedCategory() {
        return new AuthorizedCategoryDomain();
    }

    public void setId(UUID id) {
        this.id = id == null ? getNewUUID() : getDefaultUUID(id);
    }

    public void setCategory(String category) {
        this.category = UtilText.getUtilText().trim(category);
    }
}
