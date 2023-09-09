package co.edu.uco.carpooling.service.facade;

public interface PatchUseCaseFacade <I, J, T> {
    void execute(I id, J json,T dto);
}
