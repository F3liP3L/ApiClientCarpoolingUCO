package co.edu.uco.carpooling.dto;

import static co.edu.uco.crosscutting.util.UtilNumeric.ZERO;
import co.edu.uco.crosscutting.util.UtilObject;

import static co.edu.uco.crosscutting.util.UtilNumeric.getUtilNumeric;
import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;
import static co.edu.uco.crosscutting.util.UtilText.EMPTY;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;

import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class VehicleDTO {
    private UUID id;
    private String plate;
    private int capacity;
    private DriverDTO owner;

    public VehicleDTO(UUID id, String plate, int capacity, DriverDTO owner) {
        setId(id);
        setPlate(plate);
        setCapacity(capacity);
        setOwner(owner);
    }

    public VehicleDTO() {
        setId(UtilUUID.getDefaultUUID(id));
        setPlate(EMPTY);
        setCapacity(ZERO);
        setOwner(DriverDTO.createNewDriver());
    }

    public static VehicleDTO createNewVehicle() {
        return new VehicleDTO();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getUtilUUID().getDefaultUUID(id);
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = getUtilText().trim(plate);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = (int) getUtilNumeric().getDefault(capacity);
    }

    public DriverDTO getOwner() {
        return owner;
    }

    public void setOwner(DriverDTO owner) {
        this.owner = getUtilObject().getDefaultIsNull(owner,DriverDTO.createNewDriver());
    }
}
