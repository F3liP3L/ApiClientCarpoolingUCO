package co.edu.uco.carpooling.service.facade.route.implementation;

import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.facade.route.RouteSaveUseCaseFacade;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.carpooling.service.usecase.route.SaveRouteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveRouteUseCaseFacadeImpl implements RouteSaveUseCaseFacade {
    @Autowired
    private DTOAssembler<RouteDTO,RouteDomain> dtoAssembler;
    @Autowired
    private SaveRouteUseCase saveRouteUseCase;
    @Override
    public void execute(RouteDTO dto) {
        saveRouteUseCase.execute(dtoAssembler.assembleDomain(dto));
    }
}
