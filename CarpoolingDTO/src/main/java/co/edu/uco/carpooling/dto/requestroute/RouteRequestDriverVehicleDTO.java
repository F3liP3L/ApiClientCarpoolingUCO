package co.edu.uco.carpooling.dto.requestroute;

import co.edu.uco.carpooling.dto.DriverPerVehicleDTO;
import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilText.EMPTY;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;

public class RouteRequestDriverVehicleDTO {
    private UUID id;
    private String name;
    private String nameVehicle;
    public UUID getId() {
        return id;
    }
    public RouteRequestDriverVehicleDTO() {
        setId(UtilUUID.getDefaultUUID(id));
        setName(EMPTY);
        setNameVehicle(EMPTY);
    }

    public RouteRequestDriverVehicleDTO(UUID id, String name, String nameVehicle) {
        setId(id);
        setName(name);
        setNameVehicle(nameVehicle);
    }

    public void setId(UUID id) {
        this.id = UtilObject.getUtilObject().getDefaultIsNull(id, UtilUUID.getNewUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = getUtilText().trim(name);
    }

    public String getNameVehicle() {
        return nameVehicle;
    }

    public void setNameVehicle(String nameVehicle) {
        this.nameVehicle = getUtilText().trim(nameVehicle);
    }

    public static RouteRequestDriverVehicleDTO create() {
        return new RouteRequestDriverVehicleDTO();
    }

    @Override
    public String toString() {
        return "RouteRequestDriverVehicleDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameVehicle='" + nameVehicle + '\'' +
                '}';
    }
}
