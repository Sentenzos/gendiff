package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.function.Predicate;

public class Parser {
    public static Map<String, Object> parse(Path path) throws Exception {
        Map<String, Object> result;
        Predicate<String> extension = ex -> path.getFileName().toString().endsWith(ex);

        if (extension.test(".yml")) {
            ObjectMapper mapper = new YAMLMapper();
            result = mapper.readValue(Files.readString(path), new TypeReference<>() { });
        } else if (extension.test(".json")) {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(Files.readString(path), new TypeReference<>() { });
        } else {
            throw new Exception("The format is not supported");
        }

        return result;
    }
}
