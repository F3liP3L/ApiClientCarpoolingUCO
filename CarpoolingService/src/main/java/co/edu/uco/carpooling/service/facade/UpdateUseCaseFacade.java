package co.edu.uco.carpooling.service.facade;

public interface UpdateUseCaseFacade<U,T> {
    void execute(U uuid, T dto);
}
