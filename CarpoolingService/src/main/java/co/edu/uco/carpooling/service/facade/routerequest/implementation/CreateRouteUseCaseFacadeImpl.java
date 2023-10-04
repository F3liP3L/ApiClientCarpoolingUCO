package co.edu.uco.carpooling.service.facade.routerequest.implementation;

import co.edu.uco.carpooling.dto.RouteRequestDTO;
import co.edu.uco.carpooling.service.domain.RouteRequestDomain;
import co.edu.uco.carpooling.service.facade.routerequest.CreateRouteUseCaseFacade;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.carpooling.service.usecase.route.CreateRouteUseCase;
import co.edu.uco.crosscutting.util.UtilUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateRouteUseCaseFacadeImpl implements CreateRouteUseCaseFacade {
    @Autowired
    private CreateRouteUseCase createRouteUseCase;
    @Autowired
    private DTOAssembler<RouteRequestDTO, RouteRequestDomain> dtoAssembler;
    @Override
    public void execute(RouteRequestDTO dto) {
        dto.setId(UtilUUID.getNewUUID());
        RouteRequestDomain routeRequestDomain = dtoAssembler.assembleDomain(dto);
        createRouteUseCase.execute(routeRequestDomain);
    }
}
