package co.edu.uco.carpooling.service.usecase.route;

import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.service.usecase.FindUseCase;

import java.util.UUID;

public interface FindRouteCreateUseCase extends FindUseCase<RouteDTO, UUID> {
}
