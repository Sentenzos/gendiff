package hexlet.code;

import hexlet.code.formatters.Formatter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Map;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Path path1 = Paths.get(filePath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filePath2).toAbsolutePath().normalize();

        if (!Files.exists(path1)) {
            throw new Exception("File '" + path1 + "' does not exist");
        } else if (!Files.exists(path2)) {
            throw new Exception("File '" + path2 + "' does not exist");
        }

        Map<String, Object> map1 = Parser.parse(path1);
        Map<String, Object> map2 = Parser.parse(path2);

        List<String> list = Stream.of(map1.keySet(), map2.keySet()).
                flatMap(Collection::stream)
                .collect(Collectors.toSet())
                .stream()
                .sorted()
                .toList();

        var diffView = DiffView.get(list, map1, map2);
        return Formatter.format(diffView, format);
    }
}
