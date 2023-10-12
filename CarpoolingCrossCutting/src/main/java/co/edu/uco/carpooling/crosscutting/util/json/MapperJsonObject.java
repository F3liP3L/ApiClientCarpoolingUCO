package co.edu.uco.carpooling.crosscutting.util.json;

import java.util.Optional;

public interface MapperJsonObject {

    Optional<String> execute(Object object);

    <T> Optional<T> execute(String json, Class<T> targetClass);

    Optional<String> executeGson (Object object);
}
