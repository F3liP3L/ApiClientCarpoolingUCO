package co.edu.uco.carpooling.domain;

import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class AuthorizedCategoryDomain {
    private UUID id;
    private String category;
    private String expiration;

    public AuthorizedCategoryDomain(UUID id, String category, String expiration) {
        setId(id);
        setCategory(category);
        setExpiration(expiration);
    }

    public AuthorizedCategoryDomain() {
        setId(UtilUUID.getUtilUUID().getNewUUID());
        setCategory(UtilText.EMPTY);
        setExpiration(UtilText.EMPTY);
    }

    public static AuthorizedCategoryDomain createNewAuthorizedCategory() {
        return new AuthorizedCategoryDomain();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getUtilUUID().getDefaultUUID(id);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = UtilText.getUtilText().trim(category);
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = UtilText.getUtilText().trim(expiration);
    }
}
