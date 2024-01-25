package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DifferTest {
    private String expectedStylish;
    private String expectedPlain;
    private String expectedJson;

    @BeforeEach
    public void getResultFile() throws Exception  {
        Path path1 = Paths.get("./src/test/resources/stylish.txt").toAbsolutePath().normalize();
        Path path2 = Paths.get("./src/test/resources/plain.txt").toAbsolutePath().normalize();
        Path path3 = Paths.get("./src/test/resources/json.json").toAbsolutePath().normalize();
        this.expectedStylish = Files.readString(path1);
        this.expectedPlain = Files.readString(path2);
        this.expectedJson = Files.readString(path3);
    }

    @Test
    public void jsonStylishDiffTest() throws Exception {
        var actual = Differ.generate("./src/test/resources/j1.json",
                "./src/test/resources/j2.json", "stylish");
        assertEquals(expectedStylish, actual);
    }

    @Test
    public void yamlStylishDiffTest() throws Exception {
        var actual = Differ.generate("./src/test/resources/y1.yml", "./src/test/resources/y2.yml",
                "stylish");
        assertEquals(expectedStylish, actual);
    }

    @Test
    public void jsonPlainDiffTest() throws Exception {
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

    @Test
    public void throwTest() {
        assertThrows(Exception.class, () -> Differ.generate("",  "./src/test/resources/j2.json",
                "stylish"));
    }
}

