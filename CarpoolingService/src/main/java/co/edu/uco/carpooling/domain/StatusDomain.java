package co.edu.uco.carpooling.domain;

import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilUUID.getDefaultUUID;
import static co.edu.uco.crosscutting.util.UtilUUID.getNewUUID;

public class StatusDomain {
    private UUID id;
    private String status;

    public StatusDomain(UUID id, String status) {
        setId(UtilUUID.getNewUUID());
        setStatus(UtilText.EMPTY);
    }

    public StatusDomain() {
        setId(UtilUUID.getNewUUID());
        setStatus(UtilText.EMPTY);
    }

    public static StatusDomain createNewStatus() {
        return new StatusDomain();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id == null ? getNewUUID() : getDefaultUUID(id);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = UtilText.getUtilText().trim(status);
    }
}
