package co.edu.uco.carpooling.service.domain;

import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;
import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilUUID.getDefaultUUID;
import static co.edu.uco.crosscutting.util.UtilUUID.getNewUUID;

@Getter
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
        super();
        setId(UtilUUID.getNewUUID());
        setPlate(UtilText.EMPTY);
        setCapacity(UtilNumeric.ZERO);
        setOwner(DriverDomain.createNewDriver());
    }

    public static VehicleDomain createNewVehicle() {
        return new VehicleDomain();
    }

    public void setId(UUID id) {
        this.id = id == null ? getNewUUID() : getDefaultUUID(id);
    }

    public void setPlate(String plate) {
        this.plate = UtilText.getUtilText().trim(plate);
    }

    public void setCapacity(int capacity) {
        this.capacity = (int) UtilNumeric.getUtilNumeric().getDefault(capacity);
    }

    public void setOwner(DriverDomain owner) {
        this.owner = UtilObject.getUtilObject().getDefaultIsNull(owner, DriverDomain.createNewDriver());
    }
}
