package co.edu.uco.carpooling.service.usecase;

public interface CustomerCase<D>{
    void execute(D domain);
}
