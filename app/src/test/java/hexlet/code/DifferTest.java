package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private static String expectedStylish;
    private static String expectedPlain;
    private static String expectedJson;

    @BeforeAll
    public static void getResultFile() throws Exception  {
        Path path1 = Paths.get("./src/test/resources/stylish.txt").toAbsolutePath().normalize();
        Path path2 = Paths.get("./src/test/resources/plain.txt").toAbsolutePath().normalize();
        Path path3 = Paths.get("./src/test/resources/json.json").toAbsolutePath().normalize();
        expectedStylish = Files.readString(path1);
        expectedPlain = Files.readString(path2);
        expectedJson = Files.readString(path3);
    }

    @Test
    public void jsonToStylishDiffTest() throws Exception {
        var actual = Differ.generate("./src/test/resources/j1.json",
                "./src/test/resources/j2.json");
        assertEquals(expectedStylish, actual);
    }

    @Test
    public void yamlToStylishDiffTest() throws Exception {
        var actual = Differ.generate("./src/test/resources/y1.yml", "./src/test/resources/y2.yml",
                "stylish");
        assertEquals(expectedStylish, actual);
    }

    @Test
    public void jsonToPlainDiffTest() throws Exception {
        var actual = Differ.generate("./src/test/resources/j1.json",
                "./src/test/resources/j2.json", "plain");
        assertEquals(expectedPlain, actual);
    }

    @Test
    public void jsonToJsonDiffTest() throws Exception {
        var actual = Differ.generate("./src/test/resources/j1.json",
                "./src/test/resources/j2.json", "json");
        assertEquals(expectedJson, actual);
    }
}

