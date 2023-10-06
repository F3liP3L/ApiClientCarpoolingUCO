package co.edu.uco.carpooling.crosscutting.util.json;

import co.edu.uco.carpooling.crosscutting.util.json.config.LocalDateTimeDeserializer;
import co.edu.uco.crosscutting.exception.GeneralException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr353.JSR353Module;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UtilMapperJson implements MapperJsonObject {

    private final ObjectMapper mapper = new ObjectMapper();
    public UtilMapperJson() {
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
        mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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
            System.out.println(exception.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<String> executeGson(Object object) {
        try {
            Gson gson = new GsonBuilder().serializeNulls()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
                    .create();
            String objectToJson = gson.toJson(object);
            return Optional.ofNullable(objectToJson);
        } catch (GeneralException exception) {
            return Optional.empty();
        }
    }
}
