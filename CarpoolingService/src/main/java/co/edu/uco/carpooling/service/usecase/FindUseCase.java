package co.edu.uco.carpooling.service.usecase;

public interface FindUseCase<T> {
    T execute(T messageObject);
}
