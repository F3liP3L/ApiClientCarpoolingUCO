package co.edu.uco.carpooling.service.mapper.json;

public interface IJsonMapper<T, B, J> {
    T apply(B bean,J jsonType);
}
