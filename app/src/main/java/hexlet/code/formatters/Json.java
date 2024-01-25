package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import hexlet.code.DiffData;
import java.util.List;

public class Json {
    public static String format(List<DiffData> diffView) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String test = mapper.writeValueAsString(diffView);
        System.out.println(test);
        return test;
    }
}
