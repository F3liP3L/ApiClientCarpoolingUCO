package co.edu.uco.carpooling.service.usecase.route.implementation;

import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.usecase.route.FindRouteCreateUseCase;
import org.springframework.stereotype.Service;

@Service
public class FindRouteCreateUseCaseImpl implements FindRouteCreateUseCase {
    @Override
    public RouteDomain execute(RouteDomain objectMessage) {
        return objectMessage;
    }

    @Override
    public RouteDomain getRouteCreate() {
        return null;
    }
}
