package co.edu.uco.carpooling.service.domain;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilText.getUtilText;

public class PointOfInterestDomain {
    private UUID id;
    private String name;
    public PointOfInterestDomain(UUID id, String name) {
        setId(id);
        setName(name);
    }

    public PointOfInterestDomain() {
        super();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = getUtilText().trim(name);
    }

    public static final PointOfInterestDomain build() {
        return new PointOfInterestDomain();
    }

}
