package co.edu.uco.carpooling.service.usecase;

public interface FindUseCase<T, D> {
    T execute(D messageObject);
}
