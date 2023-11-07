package co.edu.uco.carpooling.service.domain.requestroute;

import co.edu.uco.carpooling.service.domain.DriverPerVehicleDomain;
import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class RouteAvailableDomain {
    private UUID id;
    private DriverPerVehicleDomain driverVehicle;
    private int routeCapacity;

    public RouteAvailableDomain(UUID id, DriverPerVehicleDomain driverVehicle, int routeCapacity) {
        setId(UtilUUID.getDefaultUUID(id));
        setDriverVehicle(driverVehicle);
        setRouteCapacity(routeCapacity);
    }

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

    public int getRouteCapacity() {
        return routeCapacity;
    }

    public void setRouteCapacity(int routeCapacity) {
        this.routeCapacity = (int) UtilNumeric.getUtilNumeric().getDefault(routeCapacity);
    }
}
