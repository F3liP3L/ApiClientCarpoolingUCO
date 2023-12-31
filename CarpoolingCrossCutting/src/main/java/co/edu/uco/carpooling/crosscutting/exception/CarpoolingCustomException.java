package co.edu.uco.carpooling.crosscutting.exception;

import co.edu.uco.crosscutting.exception.GeneralException;
import co.edu.uco.carpooling.crosscutting.exception.enumeration.ExceptionLocation;
import co.edu.uco.carpooling.crosscutting.exception.enumeration.ExceptionType;


import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;

public class CarpoolingCustomException extends GeneralException {
    private ExceptionType type;
    private ExceptionLocation location;
    protected CarpoolingCustomException(String userMessage, String technicalMessage, Exception rootException, ExceptionType type, ExceptionLocation localation) {
        super(userMessage, technicalMessage, rootException);
        setLocation(localation);
        setType(type);
    }

    public static CarpoolingCustomException buildUserException(String userMessage) {
        return new CarpoolingCustomException(userMessage, userMessage, null, ExceptionType.BUSINESS, null);
    }

    public static CarpoolingCustomException buildTechnicalException(String technicalMessage) {
        return new CarpoolingCustomException(null, technicalMessage, null, ExceptionType.TECHNICAL, null);
    }

    public static CarpoolingCustomException buildTechnicalException(String technicalMessage, Exception rootException, ExceptionLocation location) {
        return new CarpoolingCustomException(null, technicalMessage, rootException, ExceptionType.TECHNICAL, location);
    }

    public static CarpoolingCustomException buildTechnicalRepositoryException(String technicalMessage) {
        return new CarpoolingCustomException(null, technicalMessage, null, ExceptionType.TECHNICAL, ExceptionLocation.INFRASTRUCTURE);
    }

    public static CarpoolingCustomException buildTechnicalServiceException(String technicalMessage) {
        return new CarpoolingCustomException(null, technicalMessage, null, ExceptionType.TECHNICAL, ExceptionLocation.SERVICE);
    }

    public static CarpoolingCustomException buildServiceException(String businessMessage) {
        return new CarpoolingCustomException(businessMessage, null, null, ExceptionType.BUSINESS, ExceptionLocation.SERVICE);
    }

    public static CarpoolingCustomException buildTechnicalRepositoryException(String technicalMessage, Exception rootException) {
        return new CarpoolingCustomException(null, technicalMessage, rootException, ExceptionType.TECHNICAL, ExceptionLocation.INFRASTRUCTURE);
    }

    public static CarpoolingCustomException build(String userMessage, String technicalMessage) {
        return new CarpoolingCustomException(userMessage, technicalMessage, null, null, null);
    }

    public static CarpoolingCustomException build(String userMessage, String technicalMessage, Exception rootException) {
        return new CarpoolingCustomException(userMessage, technicalMessage, rootException, null, null);
    }

    public ExceptionType getType() {
        return type;
    }

    public void setType(ExceptionType type) {
        this.type = getUtilObject().getDefaultIsNull(type, ExceptionType.GENERAL);
    }

    public ExceptionLocation getLocation() {
        return location;
    }

    public void setLocation(ExceptionLocation location) {
        this.location = getUtilObject().getDefaultIsNull(location, ExceptionLocation.GENERAL);
    }
}

