package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DifferTest {
    private String expected;

    @BeforeEach
    public void getResultFile() throws Exception  {
        Path path = Paths.get("./src/test/resources/expected.txt").toAbsolutePath().normalize();
        this.expected = Files.readString(path);
    }

    @Test
    public void jsonDiffTest2() throws Exception {
        var actual = Differ.generate("./src/test/resources/j1.json",
                "./src/test/resources/j2.json", "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void yamlDiffTest() throws Exception {
        var actual = Differ.generate("./src/test/resources/y1.yml", "./src/test/resources/y2.yml",
                "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void throwTest() {
        assertThrows(Exception.class, () -> Differ.generate("",  "./src/test/resources/j2.json",
                "stylish"));
    }
}

