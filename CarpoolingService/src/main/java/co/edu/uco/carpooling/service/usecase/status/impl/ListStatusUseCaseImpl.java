package co.edu.uco.carpooling.service.usecase.status.impl;

import co.edu.uco.carpooling.dto.StatusDTO;
import co.edu.uco.carpooling.service.mapper.entityassembler.impl.StatusEntityAssembler;
import co.edu.uco.carpooling.service.port.repository.StatusRepository;
import co.edu.uco.carpooling.service.usecase.status.ListStatusUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListStatusUseCaseImpl implements ListStatusUseCase {
    @Autowired
    private StatusEntityAssembler entityAssembler;
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<StatusDTO> execute(Optional<StatusDTO> dto) {
        return statusRepository.findById(dto.get().getId()).stream()
                .map(statusEntity -> entityAssembler.assembleDTO(statusEntity)).toList();
    }
}
