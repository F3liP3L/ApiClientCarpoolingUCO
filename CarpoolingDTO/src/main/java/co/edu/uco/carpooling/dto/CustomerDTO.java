package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class CustomerDTO {
    private UUID id;

    private UserDTO user;

    public CustomerDTO(UUID id, UserDTO user) {
        setId(id);
        setUser(user);
    }

    public CustomerDTO() {
        setId(UtilUUID.getNewUUID());
        setUser(UserDTO.create());
    }

    public static CustomerDTO create() {
        return new CustomerDTO();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = UtilObject.getUtilObject().getDefaultIsNull(user, UserDTO.create());
    }
}
