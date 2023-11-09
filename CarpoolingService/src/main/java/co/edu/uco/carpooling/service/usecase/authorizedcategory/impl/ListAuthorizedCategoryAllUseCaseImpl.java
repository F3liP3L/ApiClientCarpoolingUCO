package co.edu.uco.carpooling.service.usecase.authorizedcategory.impl;

import co.edu.uco.carpooling.dto.AuthorizedCategoryDTO;
import co.edu.uco.carpooling.service.mapper.entityassembler.impl.AuthorizedCategoryEntityAssembler;
import co.edu.uco.carpooling.service.port.repository.AuthorizedCategoryRepository;
import co.edu.uco.carpooling.service.usecase.authorizedcategory.ListAuthorizedCategoryAllUseCase;
import co.edu.uco.carpooling.service.usecase.authorizedcategory.ListAuthorizedCategoryUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListAuthorizedCategoryAllUseCaseImpl implements ListAuthorizedCategoryAllUseCase {
    @Autowired
    private AuthorizedCategoryEntityAssembler entityAssembler;
    @Autowired
    private AuthorizedCategoryRepository categoryRepository;

    @Override
    public List<AuthorizedCategoryDTO> execute(Optional<AuthorizedCategoryDTO> dto) {
        return categoryRepository.findAll().stream()
                .map(authorizedCategoryEntity -> entityAssembler.assembleDTO(authorizedCategoryEntity)).toList();
    }
}
