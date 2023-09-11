package co.edu.uco.carpooling.service.usecase.driver.impl;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.DriverDTO;
import co.edu.uco.carpooling.entity.DriverEntity;
import co.edu.uco.carpooling.service.domain.DriverDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.port.repository.DriverRepository;
import co.edu.uco.carpooling.service.usecase.driver.DeleteDriverUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteDriverUseCaseImpl implements DeleteDriverUseCase {

    @Autowired
    private EntityAssembler<DriverEntity,DriverDomain, DriverDTO> entityAssembler;
    @Autowired
    private DriverRepository driverRepository;

    @Override
    public void execute(DriverDomain domain) {
        DriverEntity driverEntity = entityAssembler.assembleEntity(domain);
        try {
            driverRepository.deleteById(driverEntity.getId());
        } catch (CarpoolingCustomException exception) {
            throw exception;
        }
    }
}
