package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DifferTest {
    private  String exprected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";

    @Test
    public void jsonDiffTest() throws Exception {
        var actual = Differ.generate("./src/test/resources/j1.json", "./src/test/resources/j2.json");
        assertEquals(exprected, actual);
    }

    @Test
    public void yamlDiffTest() throws Exception {
        var actual = Differ.generate("./src/test/resources/y1.yml", "./src/test/resources/y2.yml");
        assertEquals(exprected, actual);
    }

    @Test
    public void throwTest() {
        assertThrows(Exception.class, () -> Differ.generate("",  "./src/test/resources/j2.json"));
        System.out.println("s");
    }
}

