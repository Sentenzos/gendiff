package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(Path path) throws Exception {
        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(Files.readString(path), new TypeReference<>() { });
    }
}
