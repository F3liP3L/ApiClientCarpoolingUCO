package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilUUID.getDefaultUUID;
import static co.edu.uco.crosscutting.util.UtilUUID.getNewUUID;

public class AuthorizedCategoryDTO {
    private UUID id;
    private String category;
    private String expiration;

    public AuthorizedCategoryDTO(UUID id, String category, String expiration) {
        setId(id);
        setCategory(category);
        setExpiration(expiration);
    }

    public AuthorizedCategoryDTO() {
        setId(UtilUUID.getNewUUID());
        setCategory(UtilText.EMPTY);
        setExpiration(UtilText.EMPTY);
    }

    public static AuthorizedCategoryDTO createNewAuthorizedCategory() {
        return new AuthorizedCategoryDTO();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id == null ? getNewUUID() : getDefaultUUID(id);
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
