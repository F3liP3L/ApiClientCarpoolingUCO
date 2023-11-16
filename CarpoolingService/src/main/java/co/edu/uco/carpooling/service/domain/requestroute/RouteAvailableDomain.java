package co.edu.uco.carpooling.service.domain.requestroute;

import co.edu.uco.carpooling.service.domain.DriverPerVehicleDomain;
import co.edu.uco.carpooling.service.domain.PositionDomain;
import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class RouteAvailableDomain {
    private UUID id;
    private DriverPerVehicleDomain driverVehicle;
    private PositionDomain origin;
    private PositionDomain destination;
    private int routeCapacity;

    public RouteAvailableDomain(UUID id, DriverPerVehicleDomain driverVehicle, PositionDomain origin, PositionDomain destination,
                                int routeCapacity) {
        setId(UtilUUID.getDefaultUUID(id));
        setDriverVehicle(driverVehicle);
        setRouteCapacity(routeCapacity);
        setDestination(destination);
        setOrigin(origin);
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

    public PositionDomain getOrigin() {
        return origin;
    }

    public void setOrigin(PositionDomain origin) {
        this.origin = UtilObject.getUtilObject().getDefaultIsNull(origin, PositionDomain.build());
    }

    public PositionDomain getDestination() {
        return destination;
    }

    public void setDestination(PositionDomain destination) {
        this.destination = UtilObject.getUtilObject().getDefaultIsNull(destination, PositionDomain.build());;
    }

    public int getRouteCapacity() {
        return routeCapacity;
    }

    public void setRouteCapacity(int routeCapacity) {
        this.routeCapacity = (int) UtilNumeric.getUtilNumeric().getDefault(routeCapacity);
    }
}
