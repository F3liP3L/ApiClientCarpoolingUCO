package co.edu.uco.carpooling.service.mapper.entityassembler.impl;

import co.edu.uco.carpooling.dto.AuthorizedCategoryDTO;
import co.edu.uco.carpooling.entity.AuthorizedCategoryEntity;
import co.edu.uco.carpooling.service.domain.AuthorizedCategoryDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorizedCategoryEntityAssembler implements EntityAssembler<AuthorizedCategoryEntity, AuthorizedCategoryDomain, AuthorizedCategoryDTO> {

    private final ModelMapper modelMapper;

    public AuthorizedCategoryEntityAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public AuthorizedCategoryDomain assembleDomain(AuthorizedCategoryEntity entity) {
        return modelMapper.map(entity, AuthorizedCategoryDomain.class);
    }

    @Override
    public AuthorizedCategoryEntity assembleEntity(AuthorizedCategoryDomain domain) {
        return modelMapper.map(domain, AuthorizedCategoryEntity.class);
    }

    @Override
    public AuthorizedCategoryDTO assembleDTO(AuthorizedCategoryEntity entity) {
        return modelMapper.map(entity, AuthorizedCategoryDTO.class);
    }
}
