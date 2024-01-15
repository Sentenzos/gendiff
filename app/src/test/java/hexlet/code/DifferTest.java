package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DifferTest {
    @Test
    public void generateTest() throws Exception {
        var expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        var actual = Differ.generate("./src/test/resources/j1.json", "./src/test/resources/j2.json");
        assertEquals(expected, actual);
    }

    @Test
    public void throwTest() {
        assertThrows(Exception.class, () -> Differ.generate("",  "./src/test/resources/j2.json"));
        System.out.println("s");
    }
}

