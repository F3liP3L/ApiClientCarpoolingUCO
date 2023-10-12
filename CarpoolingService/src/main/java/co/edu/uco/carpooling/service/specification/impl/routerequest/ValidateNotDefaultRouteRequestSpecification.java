package co.edu.uco.carpooling.service.specification.impl.routerequest;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.service.domain.requestroute.RouteRequestDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import org.springframework.stereotype.Component;

@Component
public class ValidateNotDefaultRouteRequestSpecification extends CompositeSpecification<RouteRequestDomain> {
    @Override
    public boolean isSatisfyBy(RouteRequestDomain object) {
        return isValid(object);
    }
    private boolean isValid(RouteRequestDomain object) {
        if (object.getOrigin().getLatitude().isEmpty() || object.getOrigin().getLongitude().isEmpty()) {
            throw CarpoolingCustomException.buildUserException("The initial position of the route has to be entered.");
        }
        if (object.getDestination().getLatitude().isEmpty() || object.getDestination().getLongitude().isEmpty()) {
            throw CarpoolingCustomException.buildUserException("The destination position of the route has to be entered.");
        }
        return true;
    }

}
