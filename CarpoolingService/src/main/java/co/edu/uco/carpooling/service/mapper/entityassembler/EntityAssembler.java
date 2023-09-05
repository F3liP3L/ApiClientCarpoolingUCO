package co.edu.uco.carpooling.service.mapper.entityassembler;

public interface EntityAssembler<E,D,T> {
    D assembleDomain(E entity);
    E assembleEntity(D domain);
    T assembleDTO(E entity);
}
