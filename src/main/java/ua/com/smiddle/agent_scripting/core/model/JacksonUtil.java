package ua.com.smiddle.agent_scripting.core.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by OAM on 25.03.2016.
 */
public class JacksonUtil {
    private final static ObjectMapper JACKSON_MAPPER = new ObjectMapper();


    //Methods
    public static String objectToJson(Object obj) throws JsonProcessingException {
        synchronized (JACKSON_MAPPER) {
            return JACKSON_MAPPER.writeValueAsString(obj);
        }
    }

    public static Object jsonToObject(String json, Class clazz) throws IOException {
        synchronized (JACKSON_MAPPER) {
            return JACKSON_MAPPER.readValue(json, clazz);
        }
    }

    public static HashMap<String, Object> unknownJsonStructureToObject(String json) throws IOException {
        synchronized (JACKSON_MAPPER) {
            return JACKSON_MAPPER.readValue(json, HashMap.class);
        }

    }
}
