package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.Map;

public class Parser {
    String extension;

    public Parser(String extension) {
        this.extension = extension;
    }

    public Map<String, Object> parse(String content) throws Exception {
        Map<String, Object> result;

        if (extension.equals("yml")) {
            ObjectMapper mapper = new YAMLMapper();
            result = mapper.readValue(content, new TypeReference<>() { });
        } else if (extension.equals("json")) {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(content, new TypeReference<>() { });
        } else {
            throw new Exception("The format is not supported");
        }

        return result;
    }
}
