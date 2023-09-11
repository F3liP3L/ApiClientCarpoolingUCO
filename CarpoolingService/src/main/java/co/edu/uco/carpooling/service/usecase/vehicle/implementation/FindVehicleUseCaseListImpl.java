package co.edu.uco.carpooling.service.usecase.vehicle.implementation;

import co.edu.uco.carpooling.dto.VehicleDTO;
import co.edu.uco.carpooling.entity.VehicleEntity;
import co.edu.uco.carpooling.service.domain.VehicleDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.port.repository.VehicleRepository;
import co.edu.uco.carpooling.service.usecase.vehicle.FindVehicleUseCaseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindVehicleUseCaseListImpl implements FindVehicleUseCaseList {
    @Autowired
    private VehicleRepository repository;
    @Autowired
    private EntityAssembler<VehicleEntity, VehicleDomain, VehicleDTO> entityAssembler;
    @Override
    public List<VehicleDTO> execute(Optional<VehicleDTO> dto) {
        return repository.findAll().stream().map(entity -> entityAssembler.assembleDTO(entity)).toList();
    }
}
