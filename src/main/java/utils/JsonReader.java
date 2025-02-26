package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map; // Import for Map
import java.util.HashMap; // Import for HashMap
import java.util.Iterator; // Import for Iterator
import java.util.Map.Entry; // Import for Map.Entry

public class JsonReader {
    private static final String JSON_PATH = "src/test/resources/data.json";

    public static Map<String, String> getCredentials(String key) {
        Map<String, String> credentialsMap = new HashMap<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File(JSON_PATH));
            JsonNode credentialsNode = jsonNode.get(key);

            if (credentialsNode != null) {
                Iterator<Map.Entry<String, JsonNode>> fields = credentialsNode.fields();
                while (fields.hasNext()) {
                    Map.Entry<String, JsonNode> entry = fields.next();
                    credentialsMap.put(entry.getKey(), entry.getValue().asText());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return credentialsMap;
    }
}
