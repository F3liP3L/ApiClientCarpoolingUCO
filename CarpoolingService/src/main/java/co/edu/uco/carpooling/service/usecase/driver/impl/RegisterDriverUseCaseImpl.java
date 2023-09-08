package co.edu.uco.carpooling.service.usecase.driver.impl;

import co.edu.uco.carpooling.adapter.repository.DriverRepository;
import co.edu.uco.carpooling.dto.DriverDTO;
import co.edu.uco.carpooling.entity.DriverEntity;
import co.edu.uco.carpooling.service.domain.DriverDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.usecase.driver.RegisterDriverUseCase;
import co.edu.uco.crosscutting.util.UtilUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterDriverUseCaseImpl implements RegisterDriverUseCase {

    @Autowired
    private EntityAssembler<DriverEntity,DriverDomain, DriverDTO> entityAssembler;
    @Autowired
    private DriverRepository driverRepository;

    @Override
    public void execute(DriverDomain domain) {
        domain.setId(UtilUUID.getNewUUID());
        DriverEntity driverEntity = entityAssembler.assembleEntity(domain);
        driverRepository.save(driverEntity);
    }
}
