package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilText.EMPTY;

public class StatusDTO {
    private UUID id;
    private String status;

    public StatusDTO(UUID id, String status) {
        setId(id);
        setStatus(status);
    }

    public StatusDTO() {
        setId(UtilUUID.getNewUUID());
        setStatus(EMPTY);
    }

    public StatusDTO(UUID id) {
        setId(id);
        setStatus(EMPTY);
    }

    public static StatusDTO createNewStatus() {
        return new StatusDTO();
    }

    public static StatusDTO create(UUID uuid) {
        return new StatusDTO(uuid);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = UtilText.getUtilText().trim(status);
    }
}
