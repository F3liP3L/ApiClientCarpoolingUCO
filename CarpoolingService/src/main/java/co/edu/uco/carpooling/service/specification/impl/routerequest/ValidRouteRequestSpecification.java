package co.edu.uco.carpooling.service.specification.impl.routerequest;

import co.edu.uco.carpooling.service.domain.RouteRequestDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidRouteRequestSpecification extends CompositeSpecification<RouteRequestDomain> {

    @Autowired
    private ValidateNotDefaultRouteRequestSpecification notDefaultSpecification;
    @Override
    public boolean isSatisfyBy(RouteRequestDomain object) {
        return notDefaultSpecification.isSatisfyBy(object);
    }
}
