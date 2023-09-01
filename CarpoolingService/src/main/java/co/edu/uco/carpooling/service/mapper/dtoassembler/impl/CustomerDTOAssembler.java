package co.edu.uco.carpooling.service.mapper.dtoassembler.impl;

import co.edu.uco.carpooling.dto.UserDTO;
import co.edu.uco.carpooling.service.domain.CustomerDomain;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTOAssembler implements DTOAssembler<UserDTO, CustomerDomain> {

    private final ModelMapper modelMapper;

    public CustomerDTOAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public CustomerDomain assembleDomain(UserDTO dto) {
        return modelMapper.map(dto, CustomerDomain.class);
    }

    @Override
    public UserDTO assembleDTO(CustomerDomain domain) {
        return modelMapper.map(domain, UserDTO.class);
    }
}
