package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilText;
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
        setId(UtilUUID.getUtilUUID().getNewUUID());
        setPlate(UtilText.EMPTY);
        setCapacity(UtilNumeric.ZERO);
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
        this.plate = UtilText.getUtilText().trim(plate);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = (int) UtilNumeric.getUtilNumeric().getDefault(capacity);
    }

    public DriverDTO getOwner() {
        return owner;
    }

    public void setOwner(DriverDTO owner) {
        this.owner = UtilObject.getUtilObject().getDefaultIsNull(owner,DriverDTO.createNewDriver());
    }
}
