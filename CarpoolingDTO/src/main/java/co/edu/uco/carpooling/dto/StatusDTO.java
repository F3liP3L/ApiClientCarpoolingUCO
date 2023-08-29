package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilUUID.getDefaultUUID;
import static co.edu.uco.crosscutting.util.UtilUUID.getNewUUID;

public class StatusDTO {
    private UUID id;
    private String status;

    public StatusDTO(UUID id, String status) {
        setId(UtilUUID.getNewUUID());
        setStatus(UtilText.EMPTY);
    }

    public StatusDTO() {
        setId(UtilUUID.getNewUUID());
        setStatus(UtilText.EMPTY);
    }

    public static StatusDTO createNewStatus() {
        return new StatusDTO();
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
