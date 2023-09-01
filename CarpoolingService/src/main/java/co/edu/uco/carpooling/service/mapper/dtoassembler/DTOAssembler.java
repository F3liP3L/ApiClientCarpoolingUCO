package co.edu.uco.carpooling.service.mapper.dtoassembler;

public interface DTOAssembler<T,D> {
    D assembleDomain(T dto);
    T assembleDTO(D domain);
}
