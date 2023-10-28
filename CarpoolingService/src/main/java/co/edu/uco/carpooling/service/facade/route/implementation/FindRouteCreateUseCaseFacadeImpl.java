package co.edu.uco.carpooling.service.facade.route.implementation;

import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.service.component.LatestRouteService;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.facade.route.FindRouteCreateUseCaseFacade;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindRouteCreateUseCaseFacadeImpl implements FindRouteCreateUseCaseFacade {
    @Autowired
    private DTOAssembler<RouteDTO, RouteDomain> dtoAssembler;
    @Autowired
    private LatestRouteService latestRouteService;

    @Override
    public RouteDTO execute() {
        return dtoAssembler.assembleDTO(latestRouteService.getLatestRoute());
    }
}
