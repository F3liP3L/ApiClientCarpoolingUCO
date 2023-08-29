package co.edu.uco.carpooling.domain;

import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;


public class VehicleDomain {
    private UUID id;
    private String plate;
    private int capacity;
    private DriverDomain owner;

    public VehicleDomain(UUID id, String plate, int capacity, DriverDomain owner) {
        setId(id);
        setPlate(plate);
        setCapacity(capacity);
        setOwner(owner);
    }

    public VehicleDomain() {
        setId(UtilUUID.getUtilUUID().getNewUUID());
        setPlate(UtilText.EMPTY);
        setCapacity(UtilNumeric.ZERO);
        setOwner(DriverDomain.createNewDriver());
    }

    public static VehicleDomain createNewVehicle() {
        return new VehicleDomain();
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

    public DriverDomain getOwner() {
        return owner;
    }

    public void setOwner(DriverDomain owner) {
        this.owner = UtilObject.getUtilObject().getDefaultIsNull(owner, DriverDomain.createNewDriver());
    }
}
