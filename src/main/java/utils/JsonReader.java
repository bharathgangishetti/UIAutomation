package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonReader {
    private static final String JSON_PATH = "src/test/resources/data.json";

    public static String getCredential(String key) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File(JSON_PATH));
            return jsonNode.get("credentials").get(key).asText();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
