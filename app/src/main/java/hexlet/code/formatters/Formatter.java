package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, Object>> diffView, String format) throws JsonProcessingException {

        return switch (format) {
            case "stylish" -> Stylish.format(diffView);
            case "plain" -> Plain.format(diffView);
            case "json" -> Json.format(diffView);
            default -> "";
        };

    }
}
