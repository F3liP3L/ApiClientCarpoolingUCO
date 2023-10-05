package co.edu.uco.carpooling.service.usecase.route.implementation;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.service.domain.RouteRequestDomain;
import co.edu.uco.carpooling.service.port.broker.MessageSenderPort;
import co.edu.uco.carpooling.service.specification.impl.routerequest.ValidRouteRequestSpecification;
import co.edu.uco.carpooling.service.usecase.route.CreateRouteUseCase;
import co.edu.uco.crosscutting.exception.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateRouteUseCaseImpl implements CreateRouteUseCase {
    @Autowired
    private MessageSenderPort<RouteRequestDomain> messageSenderPort;
    @Autowired
    private ValidRouteRequestSpecification specification;
    @Override
    public void execute(RouteRequestDomain domain) {
        try {
            specification.isSatisfyBy(domain);
            messageSenderPort.execute(domain, domain.getId().toString());
        } catch (CarpoolingCustomException exception) {
            throw exception;
        } catch (GeneralException exception) {
            throw CarpoolingCustomException.build("An unexpected error occurred while trying to register the route", "Unexpected error occurred in the use case of register route ".concat(exception.getMessage()), exception);
        }
    }
}
