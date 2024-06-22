package service.config;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ConfigReader {
    private JSONObject configObject;
    String filePath1 = "src/test/java/service/config/config.json";

    public ConfigReader() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(filePath1));
            configObject = (JSONObject) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        String value = null;
        String targetKey = (String) configObject.get("key");
        if (targetKey.equals(key)) {
            value = (String) configObject.get("value");
        }
        return value;
    }
}
