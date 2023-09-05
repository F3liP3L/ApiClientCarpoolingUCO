package co.edu.uco.carpooling.service.usecase;

public interface UpdateUseCase<U,D> {
    void execute(U uuid, D domain);
}
