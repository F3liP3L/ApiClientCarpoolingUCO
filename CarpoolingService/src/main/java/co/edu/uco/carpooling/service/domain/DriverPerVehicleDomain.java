package co.edu.uco.carpooling.service.domain;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;
import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilUUID.getDefaultUUID;
import static co.edu.uco.crosscutting.util.UtilUUID.getNewUUID;

@Getter
public class DriverPerVehicleDomain {
    private UUID id;
    private DriverDomain driver;
    private VehicleDomain vehicle;
    private StatusDomain driverPerVehicleStatus;

    public DriverPerVehicleDomain(UUID id, DriverDomain driver, VehicleDomain vehicle, StatusDomain driverPerVehicleStatus) {
        setId(id);
        setDriver(driver);
        setVehicle(vehicle);
        setDriverPerVehicleStatus(driverPerVehicleStatus);
    }

    public DriverPerVehicleDomain() {
        setVehicle(VehicleDomain.createNewVehicle());
        setDriver(DriverDomain.createNewDriver());
        setId(UtilUUID.getNewUUID());
        setDriverPerVehicleStatus(StatusDomain.createNewStatus());
    }

    public void setId(UUID id) {
        this.id = id == null ? getNewUUID() : getDefaultUUID(id);
    }

    public void setDriver(DriverDomain driver) {
        this.driver = UtilObject.getUtilObject().getDefaultIsNull(driver, DriverDomain.createNewDriver());
    }

    public void setVehicle(VehicleDomain vehicle) {
        this.vehicle = UtilObject.getUtilObject().getDefaultIsNull(vehicle, VehicleDomain.createNewVehicle());
    }

    public void setDriverPerVehicleStatus(StatusDomain driverPerVehicleStatus) {
        this.driverPerVehicleStatus = UtilObject.getUtilObject().getDefaultIsNull(driverPerVehicleStatus, StatusDomain.createNewStatus());
    }
}