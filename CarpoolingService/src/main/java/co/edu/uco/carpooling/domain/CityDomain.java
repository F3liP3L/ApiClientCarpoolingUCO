package co.edu.uco.carpooling.domain;

import co.edu.uco.crosscutting.util.UtilText;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilUUID.getDefaultUUID;

public class CityDomain {

    private UUID id;
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = UtilText.getUtilText().trim(name);}

}
