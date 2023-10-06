package co.edu.uco.carpooling.service.usecase.route;

import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.usecase.FindUseCase;

public interface FindRouteCreateUseCase extends FindUseCase<RouteDomain> {
    RouteDomain getRouteCreate();
}
