package co.edu.uco.carpooling.service.mapper.dtoassembler.impl;

import co.edu.uco.carpooling.dto.CustomerDTO;
import co.edu.uco.carpooling.service.domain.CustomerDomain;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTOAssembler implements DTOAssembler<CustomerDTO, CustomerDomain> {

    private final ModelMapper modelMapper;

    public CustomerDTOAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public CustomerDomain assembleDomain(CustomerDTO dto) {
        return modelMapper.map(dto, CustomerDomain.class);
    }

    @Override
    public CustomerDTO assembleDTO(CustomerDomain domain) {
        return modelMapper.map(domain, CustomerDTO.class);
    }
}
