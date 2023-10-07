package co.edu.uco.carpooling.service.facade.route.impl;

import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.facade.route.FindRouteCreateUseCaseFacade;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.carpooling.service.port.broker.route.ReceiverRouteCreatePort;
import co.edu.uco.carpooling.service.usecase.route.FindRouteCreateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindRouteCreateUseCaseFacadeImpl implements FindRouteCreateUseCaseFacade {
    @Autowired
    private DTOAssembler<RouteDTO, RouteDomain> dtoAssembler;
    @Autowired
    private FindRouteCreateUseCase routeCreateUseCase;
    @Autowired
    private ReceiverRouteCreatePort receiverRouteCreatePort;
    @Override
    public RouteDTO execute() {
        return dtoAssembler.assembleDTO(receiverRouteCreatePort.getMessage());
    }
}
