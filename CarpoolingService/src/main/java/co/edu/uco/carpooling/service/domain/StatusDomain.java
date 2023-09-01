package co.edu.uco.carpooling.service.domain;

import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class StatusDomain {
    private UUID id;
    private String status;

    public StatusDomain(UUID id, String status) {
        setId(id);
        setStatus(status);
    }

    public StatusDomain() {
        setId(UtilUUID.getUtilUUID().getNewUUID());
        setStatus(UtilText.EMPTY);
    }

    public static StatusDomain createNewStatus() {
        return new StatusDomain();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getUtilUUID().getDefaultUUID(id);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = UtilText.getUtilText().trim(status);
    }

}
