package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    private static String resourcesPath = "./src/test/resources/";
    private static String json1Path = resourcesPath + "j1.json";
    private static String json2Path = resourcesPath + "j2.json";
    private static String yaml1Path = resourcesPath + "y1.yml";
    private static  String yaml2Path = resourcesPath + "y2.yml";

    @BeforeAll
    public static void getResultFile() throws Exception  {
        Path path1 = Paths.get(resourcesPath + "stylish.txt").toAbsolutePath().normalize();
        Path path2 = Paths.get(resourcesPath + "plain.txt").toAbsolutePath().normalize();
        Path path3 = Paths.get(resourcesPath + "json.json").toAbsolutePath().normalize();
        expectedStylish = Files.readString(path1);
        expectedPlain = Files.readString(path2);
        expectedJson = Files.readString(path3);
    }

    @Test
    public void jsonToDefaultDiffTest() throws Exception {
        var actual = Differ.generate(json1Path, json2Path);
        assertEquals(expectedStylish, actual);
    }

    @Test
    public void jsonToStylishDiffTest() throws Exception {
        var actual = Differ.generate(json1Path, json2Path, "stylish");
        assertEquals(expectedStylish, actual);
    }

    @Test
    public void jsonToPlainDiffTest() throws Exception {
        var actual = Differ.generate(json1Path, json2Path, "plain");
        assertEquals(expectedPlain, actual);
    }

    @Test
    public void jsonToJsonDiffTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        var actual = Differ.generate(json1Path, json2Path, "json");
        assertEquals(mapper.readTree(expectedJson), mapper.readTree(actual));
    }

    @Test
    public void yamlToDefaultDiffTest() throws Exception {
        var actual = Differ.generate(yaml1Path, yaml2Path);
        assertEquals(expectedStylish, actual);
    }

    @Test
    public void yamlToStylishDiffTest() throws Exception {
        var actual = Differ.generate(yaml1Path, yaml2Path, "stylish");
        assertEquals(expectedStylish, actual);
    }

    @Test
    public void yamlToPlainDiffTest() throws Exception {
        var actual = Differ.generate(yaml1Path, yaml2Path, "plain");
        assertEquals(expectedPlain, actual);
    }

    @Test
    public void yamlToJsonDiffTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        var actual = Differ.generate(yaml1Path, yaml2Path, "json");
        assertEquals(mapper.readTree(expectedJson), mapper.readTree(actual));
    }

}

