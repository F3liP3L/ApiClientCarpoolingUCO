package co.edu.uco.carpooling.service.domain.requestroute;

import co.edu.uco.carpooling.service.domain.PositionDomain;
import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class RouteRequestDomain {
    private UUID id;
    private RouteRequestDriverVehicleDomain driverVehicle;
    private int routeCapacity;
    private PositionDomain origin;
    private PositionDomain destination;

    public RouteRequestDomain() {
        setId(UtilUUID.getDefaultUUID(UtilUUID.getDefaultUUID(id)));
        setDriverVehicle(RouteRequestDriverVehicleDomain.build());
        setOrigin(PositionDomain.build());
        setDestination(PositionDomain.build());
        setRouteCapacity(UtilNumeric.ZERO);
    }

    public RouteRequestDomain(UUID id, RouteRequestDriverVehicleDomain driverVehicle, PositionDomain origin, PositionDomain destination, int routeCapacity) {
        setId(id);
        setDriverVehicle(driverVehicle);
        setOrigin(origin);
        setDestination(destination);
        setRouteCapacity(routeCapacity);
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
    }
    public RouteRequestDriverVehicleDomain getDriverVehicle() {
        return driverVehicle;
    }
    public void setDriverVehicle(RouteRequestDriverVehicleDomain driverVehicle) {
        this.driverVehicle = UtilObject.getUtilObject().getDefaultIsNull(driverVehicle, RouteRequestDriverVehicleDomain.build());
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
        this.destination = UtilObject.getUtilObject().getDefaultIsNull(destination, PositionDomain.build());
    }

    public int getRouteCapacity() {
        return routeCapacity;
    }

    public void setRouteCapacity(int routeCapacity) {
        this.routeCapacity = (int) UtilNumeric.getUtilNumeric().getDefault(routeCapacity);
    }
}
