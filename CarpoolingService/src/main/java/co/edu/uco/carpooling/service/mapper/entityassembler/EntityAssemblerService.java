package co.edu.uco.carpooling.service.mapper.entityassembler;

public interface EntityAssemblerService<E,D> {
    D assembleDomain(E entity);
    E assembleEntity(D domain);
}
