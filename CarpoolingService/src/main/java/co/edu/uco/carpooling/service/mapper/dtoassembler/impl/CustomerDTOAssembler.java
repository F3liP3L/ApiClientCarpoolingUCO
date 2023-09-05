package co.edu.uco.carpooling.service.mapper.dtoassembler.impl;

import co.edu.uco.carpooling.dto.CustomerDTO;
import co.edu.uco.carpooling.service.domain.UserDomain;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTOAssembler implements DTOAssembler<CustomerDTO, UserDomain> {

    private final ModelMapper modelMapper;

    public CustomerDTOAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public UserDomain assembleDomain(CustomerDTO dto) {
        return modelMapper.map(dto, UserDomain.class);
    }

    @Override
    public CustomerDTO assembleDTO(UserDomain domain) {
        return modelMapper.map(domain, CustomerDTO.class);
    }
}
