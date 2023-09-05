package co.edu.uco.carpooling.service.usecase;

public interface UseCase<D>{
    void execute(D domain);
}
