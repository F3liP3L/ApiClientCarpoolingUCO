package co.edu.uco.carpooling.service.domain;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilText.EMPTY;

public class RouteRequestDomain {
    private UUID id;
    private DriverPerVehicleDomain driverVehicle;
    private String origin;
    private String destination;

    public RouteRequestDomain() {
        setId(UtilUUID.getDefaultUUID(UtilUUID.getDefaultUUID(id)));
        setDriverVehicle(DriverPerVehicleDomain.build());
        setOrigin(EMPTY);
        setDestination(EMPTY);
    }

    public RouteRequestDomain(UUID id, DriverPerVehicleDomain driverVehicle, String origin, String destination) {
        setId(id);
        setDriverVehicle(driverVehicle);
        setOrigin(origin);
        setDestination(destination);
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = UtilText.getUtilText().trim(origin);
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = UtilText.getUtilText().trim(destination);}

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
    }
    public DriverPerVehicleDomain getDriverVehicle() {
        return driverVehicle;
    }
    public void setDriverVehicle(DriverPerVehicleDomain driverVehicle) {
        this.driverVehicle = UtilObject.getUtilObject().getDefaultIsNull(driverVehicle, DriverPerVehicleDomain.build());
    }
}
