package co.edu.uco.carpooling.crosscutting.util;

import co.edu.uco.crosscutting.exception.GeneralException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class UtilMapperJson implements MapperJsonObject {

    private final ObjectMapper mapper;
    public UtilMapperJson() {
        this.mapper = new ObjectMapper();
    }

    @Override
    public Optional<String> execute(Object object) {
        try {
            return Optional.ofNullable(mapper.writeValueAsString(object));
        } catch (JsonProcessingException exception) {
            return Optional.empty();
        }
    }

    @Override
    public <T> Optional<T> execute(String json, Class<T> targetClass) {
        try {
            return Optional.ofNullable(mapper.readValue(json, targetClass));
        } catch (GeneralException | JsonProcessingException exception) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<String> executeGson(Object object) {
        try {
            Gson gson = new GsonBuilder().serializeNulls()
                    .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, typeOfT, context) -> LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                    .create();
            String objectToJson = gson.toJson(object);
            return Optional.ofNullable(objectToJson);
        } catch (GeneralException exception) {
            return Optional.empty();
        }
    }
}
