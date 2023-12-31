package co.edu.uco.crosscutting.util;

import co.edu.uco.crosscutting.exception.GeneralException;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;

public class UtilUUID {
    private static final UtilUUID INSTANCE = new UtilUUID();
    public static final String DEFAULT_UUID_STRING = "00000000-0000-0000-0000-000000000000";
    public static final UUID DEFAULT_UUID = getStringToUUID(DEFAULT_UUID_STRING);
    private UtilUUID() {}
    public static UtilUUID getUtilUUID() {
        return INSTANCE;
    }

    public final UUID getDefaultUUID(final UUID uuid) {
        return getUtilObject().getDefaultIsNull(uuid, DEFAULT_UUID);
    }

    public final boolean isEqual(final UUID uuidOne, final UUID uuidTwo) {
        return getDefaultUUID(uuidOne).equals(getDefaultUUID(uuidTwo));
    }

    public final UUID getNewUUID() {
        UUID uuid;
        do {
            uuid = UUID.randomUUID();
        } while (isEqual(uuid, DEFAULT_UUID));
        return uuid;
    }

    public final UUID getUUIDFromString(final String uuidString) {
        UUID uuid = DEFAULT_UUID;
        if(!isNull(getStringToUUID(uuidString)) || ! getUtilText().isEmpty(getUtilText().trim(uuidString))) {
            try {
                uuid = UUID.fromString(uuidString);
            } catch (IllegalArgumentException excepcion) {
                throw GeneralException.build("The UUID to be converted has no valid format.",excepcion);
            } catch (Exception exception){
                throw GeneralException.build("An unexpected error trying converted", exception);
            }
        }
        return uuid;
    }

    public final String getStringFromUUID(final UUID uuid) {
        String uuidString = DEFAULT_UUID_STRING;
        if(!isNull(uuid)) {
            uuidString = uuid.toString();
        }
        return uuidString;
    }

    public static UUID getStringToUUID(final String uuid){
        return UUID.fromString(uuid);
    }

    public boolean isNull(UUID value) {
        return UtilObject.getUtilObject().isNull(value);}
}
