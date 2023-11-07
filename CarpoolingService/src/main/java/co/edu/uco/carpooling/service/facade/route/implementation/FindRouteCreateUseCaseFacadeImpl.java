package co.edu.uco.carpooling.service.facade.route.implementation;

import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.service.facade.route.FindRouteCreateUseCaseFacade;
import org.springframework.stereotype.Service;

@Service
public class FindRouteCreateUseCaseFacadeImpl implements FindRouteCreateUseCaseFacade {
    @Override
    public RouteDTO execute() {
        return new RouteDTO();
    }
}
