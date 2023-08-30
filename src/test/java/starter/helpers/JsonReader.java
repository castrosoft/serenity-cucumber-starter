package starter.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonReader {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, String> getDataFrom(String filePath) {
        try {
            List<Map<String, String>> users = objectMapper.readValue(new File(filePath), new TypeReference<List<Map<String, String>>>() {
            });
            // Assuming your JSON has an array of user objects, each containing "username" and "password" fields
            return users.get(0); // You can implement logic to select a user based on your requirements
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
