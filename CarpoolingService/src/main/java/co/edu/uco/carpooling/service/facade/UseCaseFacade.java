package co.edu.uco.carpooling.service.facade;

public interface UseCaseFacade<D> {
    void execute(D dto);
}
