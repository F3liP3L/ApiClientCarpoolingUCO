package co.edu.uco.carpooling.service.usecase.driver.impl;

import co.edu.uco.carpooling.adapter.repository.DriverRepository;
import co.edu.uco.carpooling.dto.DriverDTO;
import co.edu.uco.carpooling.service.domain.DriverDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.impl.DriverEntityAssembler;
import co.edu.uco.carpooling.service.usecase.driver.ListDriverUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListAllDriverUseCaseIpl implements ListDriverUseCase {

    @Autowired
    private DriverEntityAssembler entityAssembler;

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public List<DriverDTO> execute(Optional<DriverDTO> dto) {
        return driverRepository.findAll().stream()
                .map(driverEntity -> entityAssembler.assembleDTO(driverEntity)).toList();
    }
}
