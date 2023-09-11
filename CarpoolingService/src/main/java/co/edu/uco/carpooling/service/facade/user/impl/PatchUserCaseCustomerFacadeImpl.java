package co.edu.uco.carpooling.service.facade.user.impl;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.entity.CustomerEntity;
import co.edu.uco.carpooling.service.facade.user.PatchUserUseCaseFacade;
import co.edu.uco.carpooling.service.mapper.json.JsonPatchMapper;
import co.edu.uco.carpooling.service.port.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.JsonPatch;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class PatchUserCaseCustomerFacadeImpl implements PatchUserUseCaseFacade {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private JsonPatchMapper<CustomerEntity> jsonPatchMapper;

    @Override
    public void execute(UUID id, JsonPatch domain) {
        Optional<CustomerEntity> customer = repository.findById(id);
        if (customer.isPresent()) {
            CustomerEntity entity = jsonPatchMapper.apply(customer.get(), domain);
            log.info(entity.toString());
            repository.save(entity);
        } else {
            throw CarpoolingCustomException.buildUserException("No se encontro vehiculo que actualizar.");
        }
    }
}
