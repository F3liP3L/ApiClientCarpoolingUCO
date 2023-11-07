package co.edu.uco.carpooling.service.domain;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilDate.TIME;
import static co.edu.uco.crosscutting.util.UtilDate.getUtilDate;
import static co.edu.uco.crosscutting.util.UtilNumeric.ZERO;
import static co.edu.uco.crosscutting.util.UtilNumeric.getUtilNumeric;

public class RouteDomain {
    private UUID id;
    private DriverPerVehicleDomain driverVehicle;
    private int routeCapacity;
    private List<PositionDomain> positions;
    private List<String> pointOfInterest;
    private LocalDateTime routeTime;
    private String status;

    public RouteDomain(UUID id, DriverPerVehicleDomain driverVehicle, int routeCapacity, List<String> pointOfInterest, List<PositionDomain> positions, LocalDateTime routeTime, String status) {
        setId(id);
        setDriverVehicle(driverVehicle);
        setRouteCapacity(routeCapacity);
        setPointOfInterest(pointOfInterest);
        setRouteTime(routeTime);
        setPositions(positions);
        setStatus(status);
    }

    public RouteDomain() {
        setId(UtilUUID.getDefaultUUID(UtilUUID.getDefaultUUID(id)));
        setDriverVehicle(driverVehicle);
        setRouteCapacity(ZERO);
        setPointOfInterest(new ArrayList<>());
        setRouteTime(TIME);
        setPositions(new ArrayList<>());
        setStatus(UtilText.EMPTY);
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
        this.driverVehicle = driverVehicle;
    }

    public int getRouteCapacity() {
        return routeCapacity;
    }

    public void setRouteCapacity(int routeCapacity) {
        this.routeCapacity = (int) getUtilNumeric().getDefault(routeCapacity);
    }

    public List<String> getPointOfInterest() {
        return pointOfInterest;
    }

    public void setPointOfInterest(List<String> pointOfInterest) {
        this.pointOfInterest = UtilObject.getUtilObject().getDefaultIsNull(pointOfInterest,List.of(UtilText.EMPTY));
    }

    public LocalDateTime getRouteTime() {
        return routeTime;
    }

    public void setRouteTime(LocalDateTime routeTime) {
        this.routeTime = getUtilDate().getDefaultTimeIfNull(routeTime);
    }
    public List<PositionDomain> getPositions() {
        return positions;
    }
    public void setPositions(List<PositionDomain> positions) {
        this.positions = UtilObject.getUtilObject().getDefaultIsNull(positions, new ArrayList<>());
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = UtilText.getUtilText().trim(status);
    }
    @Override
    public String toString() {
        return "RouteDomain{" +
                "id=" + id +
                ", driverVehicle=" + driverVehicle +
                ", routeCapacity=" + routeCapacity +
                ", positions=" + positions +
                ", pointOfInterest=" + pointOfInterest +
                ", routeTime=" + routeTime +
                '}';
    }
}
