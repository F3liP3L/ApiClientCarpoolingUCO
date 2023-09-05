package co.edu.uco.carpooling.service.domain;

import co.edu.uco.carpooling.dto.CustomerDTO;
import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class CustomerDomain {
    private UUID id;
    private UserDomain user;

    public CustomerDomain(UUID id, UserDomain user) {
        setId(id);
        setUser(user);
    }

    public CustomerDomain() {
        setId(UtilUUID.getNewUUID());
        setUser(UserDomain.build());
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

    public UserDomain getUser() {
        return user;
    }

    public void setUser(UserDomain user) {
        this.user = UtilObject.getUtilObject().getDefaultIsNull(user, UserDomain.build());
    }
}
