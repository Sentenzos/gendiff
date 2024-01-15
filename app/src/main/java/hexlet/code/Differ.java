package hexlet.code;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.List;
import java.util.Collection;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        Path path1 = Paths.get(filePath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filePath2).toAbsolutePath().normalize();

        if (!Files.exists(path1)) {
            throw new Exception("File '" + path1 + "' does not exist");
        } else if (!Files.exists(path2)) {
            throw new Exception("File '" + path2 + "' does not exist");
        }

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map1 = mapper.readValue(Files.readString(path1), new TypeReference<>() { });
        Map<String, Object> map2 = mapper.readValue(Files.readString(path2), new TypeReference<>() { });

        List<String> list = Stream.of(map1.keySet(), map2.keySet()).
                flatMap(Collection::stream)
                .collect(Collectors.toSet())
                .stream()
                .sorted()
                .toList();

        StringBuilder result = new StringBuilder();
        result.append("{");

        for (String key: list) {
            if (!map1.containsKey(key)) {
                result.append("\n\s\s")
                        .append("+").append(" ").append(key).append(":").append(" ").append(map2.get(key));
            } else if (!map2.containsKey(key)) {
                result.append("\n\s\s")
                        .append("-").append(" ").append(key).append(":").append(" ").append(map1.get(key));
            } else if (!map1.get(key).equals(map2.get(key))) {
                result.append("\n\s\s")
                        .append("-").append(" ").append(key).append(":").append(" ").append(map1.get(key));
                result.append("\n\s\s")
                        .append("+").append(" ").append(key).append(":").append(" ").append(map2.get(key));
            } else {
                result.append("\n\s\s\s\s")
                        .append(key).append(":").append(" ").append(map1.get(key));
            }
        }

        result.append("\n}");

        return result.toString();
    }
}
