package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilUUID.getDefaultUUID;
import static co.edu.uco.crosscutting.util.UtilUUID.getNewUUID;

public class DriverPerVehicleDTO {
    private UUID id;
    private DriverDTO driver;
    private VehicleDTO vehicle;
    private StatusDTO driverPerVehicleStatus;

    public DriverPerVehicleDTO(UUID id, DriverDTO driver, VehicleDTO vehicle, StatusDTO driverPerVehicleStatus) {
        setId(id);
        setDriver(driver);
        setVehicle(vehicle);
        setDriverPerVehicleStatus(driverPerVehicleStatus);
    }

    public DriverPerVehicleDTO() {
        setVehicle(VehicleDTO.createNewVehicle());
        setDriver(DriverDTO.createNewDriver());
        setId(UtilUUID.getNewUUID());
        setDriverPerVehicleStatus(StatusDTO.createNewStatus());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id == null ? getNewUUID() : getDefaultUUID(id);
    }

    public DriverDTO getDriver() {
        return driver;
    }

    public void setDriver(DriverDTO driver) {
        this.driver = UtilObject.getUtilObject().getDefaultIsNull(driver,DriverDTO.createNewDriver());
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = UtilObject.getUtilObject().getDefaultIsNull(vehicle,VehicleDTO.createNewVehicle());
    }

    public StatusDTO getDriverPerVehicleStatus() {
        return driverPerVehicleStatus;
    }

    public void setDriverPerVehicleStatus(StatusDTO driverPerVehicleStatus) {
        this.driverPerVehicleStatus = UtilObject.getUtilObject().getDefaultIsNull(driverPerVehicleStatus,StatusDTO.createNewStatus());
    }
}
