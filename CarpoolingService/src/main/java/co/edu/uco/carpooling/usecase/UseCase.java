package co.edu.uco.carpooling.usecase;

public interface UseCase <D>{
    void execute(D domain);
}
