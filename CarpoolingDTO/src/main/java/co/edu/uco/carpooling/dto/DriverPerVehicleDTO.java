package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

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
        setId(UtilUUID.getNewUUID());
        setVehicle(VehicleDTO.create());
        setDriver(DriverDTO.createNewDriver());
        setDriverPerVehicleStatus(StatusDTO.createNewStatus());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
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
        this.vehicle = UtilObject.getUtilObject().getDefaultIsNull(vehicle,VehicleDTO.create());
    }

    public StatusDTO getDriverPerVehicleStatus() {
        return driverPerVehicleStatus;
    }

    public void setDriverPerVehicleStatus(StatusDTO driverPerVehicleStatus) {
        this.driverPerVehicleStatus = UtilObject.getUtilObject().getDefaultIsNull(driverPerVehicleStatus,StatusDTO.createNewStatus());
    }
    public static DriverPerVehicleDTO create() {
        return new DriverPerVehicleDTO();
    }
}
