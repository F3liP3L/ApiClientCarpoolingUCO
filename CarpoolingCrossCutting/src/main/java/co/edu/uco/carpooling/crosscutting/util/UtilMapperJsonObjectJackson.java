package co.edu.uco.carpooling.crosscutting.util;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilMapperJsonObjectJackson implements MapperJsonObject {

    @Override
    public Optional<String> execute(Object object) {
        return Optional.empty();
    }

    @Override
    public <T> Optional<T> execute(String json, Class<T> targetClass) {
        return Optional.empty();
    }

    @Override
    public Optional<String> executeGson(Object object) {
        return Optional.empty();
    }
}
