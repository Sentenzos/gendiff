package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer>  {

    @Parameters(paramLabel = "filePath1", description = "path to first file")
    private String filePath1;

    @Parameters(paramLabel = "filePath2", description = "path to second file")
    private String filePath2;

    @Option(paramLabel = "format", names = {"-f", "--format"},
            description = "output format [default: stylish]", defaultValue = "stylish")
    private String format = "stylish";

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    /**
     *
     * @return null
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {
        var result = Differ.generate(filePath1, filePath2, format);
        System.out.println(result);
        return 0;
    }
}
