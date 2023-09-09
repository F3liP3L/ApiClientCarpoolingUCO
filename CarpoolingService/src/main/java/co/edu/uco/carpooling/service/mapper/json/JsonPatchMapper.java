package co.edu.uco.carpooling.service.mapper.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr353.JSR353Module;
import org.springframework.stereotype.Component;

import javax.json.JsonPatch;
import javax.json.JsonStructure;
import javax.json.JsonValue;

@Component
public class JsonPatchMapper<T> implements IJsonMapper<T, T, JsonPatch> {

    private ObjectMapper objectMapper;

    public JsonPatchMapper(ObjectMapper objectMapper) {
        objectMapper.registerModule(new JSR353Module());
        this.objectMapper = objectMapper;
    }

    @Override
    public T apply(T targetBean, JsonPatch patch) {
        // Convert the Java bean to a JSON document
        JsonStructure target = objectMapper.convertValue(targetBean, JsonStructure.class);
        // Apply the JSON Patch to the JSON document
        JsonValue patched = patch.apply(target);
        // Convert the JSON document to a Java bean and return it
        return objectMapper.convertValue(patched, (Class<T>)targetBean.getClass());
    }

    private void configMapper(ObjectMapper objectMapper) {
        objectMapper.registerModule(new JSR353Module());
    }

}
