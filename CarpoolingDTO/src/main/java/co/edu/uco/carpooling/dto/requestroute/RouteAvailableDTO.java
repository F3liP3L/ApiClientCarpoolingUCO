package co.edu.uco.carpooling.dto.requestroute;

import co.edu.uco.carpooling.dto.DriverPerVehicleDTO;
import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class RouteAvailableDTO {
    private UUID id;
    private DriverPerVehicleDTO driverVehicle;
    private int routeCapacity;

    public RouteAvailableDTO(UUID id, DriverPerVehicleDTO driverVehicle, int routeCapacity) {
        setId(UtilUUID.getDefaultUUID(id));
        setDriverVehicle(driverVehicle);
        setRouteCapacity(routeCapacity);
    }

    public RouteAvailableDTO() {
        setId(UtilUUID.getDefaultUUID(id));
        setRouteCapacity(UtilNumeric.ZERO);
        setDriverVehicle(DriverPerVehicleDTO.create());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
    }

    public DriverPerVehicleDTO getDriverVehicle() {
        return driverVehicle;
    }

    public void setDriverVehicle(DriverPerVehicleDTO driverVehicle) {
        this.driverVehicle = UtilObject.getUtilObject().getDefaultIsNull(driverVehicle, DriverPerVehicleDTO.create());
    }

    public int getRouteCapacity() {
        return routeCapacity;
    }

    public void setRouteCapacity(int routeCapacity) {
        this.routeCapacity = (int) UtilNumeric.getUtilNumeric().getDefault(routeCapacity);
    }

    public static RouteAvailableDTO build(){
        return new RouteAvailableDTO();
    }
}
