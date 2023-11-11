package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

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
        setId(UtilUUID.DEFAULT_UUID);
        setCategory(UtilText.EMPTY);
        setExpiration(UtilText.EMPTY);
    }

    public AuthorizedCategoryDTO(UUID uuid) {
        setId(uuid);
        setCategory(UtilText.EMPTY);
        setExpiration(UtilText.EMPTY);
    }

    public static AuthorizedCategoryDTO createNewAuthorizedCategory() {
        return new AuthorizedCategoryDTO();
    }

    public static AuthorizedCategoryDTO create(UUID id) {
        return new AuthorizedCategoryDTO(id);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
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
