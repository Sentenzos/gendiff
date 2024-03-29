package hexlet.code;

import hexlet.code.formatters.Formatter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FilenameUtils;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Map<String, Object> map1 = getData(filePath1);
        Map<String, Object> map2 = getData(filePath2);

        List<Map<String, Object>> diffView = DiffView.get(map1, map2);
        return Formatter.format(diffView, format);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    private static Map<String, Object> getData(String filePath) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        String extension = FilenameUtils.getExtension(String.valueOf(path));
        Parser parser = new Parser(extension);
        String content = Files.readString(path);
        return parser.parse(content);
    }
}
