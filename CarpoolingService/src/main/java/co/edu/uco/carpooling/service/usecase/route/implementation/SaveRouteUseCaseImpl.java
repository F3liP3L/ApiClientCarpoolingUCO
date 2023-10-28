package co.edu.uco.carpooling.service.usecase.route.implementation;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.port.broker.route.SenderRouteSavePort;
import co.edu.uco.carpooling.service.specification.impl.route.ValidRouteSpecification;
import co.edu.uco.carpooling.service.usecase.route.SaveRouteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveRouteUseCaseImpl implements SaveRouteUseCase {
    @Autowired
    private SenderRouteSavePort senderRouteSavePort;
    @Autowired
    private ValidRouteSpecification specification;
    @Override
    public void execute(RouteDomain domain) {
        try {
            specification.isSatisfyBy(domain);
            senderRouteSavePort.execute(domain, domain.getId().toString());
        } catch (CarpoolingCustomException exception) {
            throw CarpoolingCustomException.buildUserException(exception.getUserMessage());
        }

    }
}
