package hexlet.code;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, Object>> diffView, String format) {

        if (format.equals("stylish")) {
            return Formatter.stylish(diffView);
        }

        return "";
    }

    private static String stylish(List<Map<String, Object>> diffView) {
        StringBuilder result = new StringBuilder();
        result.append("{");

        for (Map<String, Object> diffInfo: diffView) {
            switch ((String) diffInfo.get("operation")) {
                case "added" -> {
                    result.append("\n\s\s")
                            .append("+").append(" ").append(diffInfo.get("key"))
                            .append(":").append(" ").append(diffInfo.get("currentValue"));
                }
                case "deleted" -> {
                    result.append("\n\s\s")
                            .append("-").append(" ").append(diffInfo.get("key"))
                            .append(":").append(" ").append(diffInfo.get("prevValue"));
                }
                case "changed" -> {
                    result.append("\n\s\s")
                            .append("-").append(" ").append(diffInfo.get("key"))
                            .append(":").append(" ").append(diffInfo.get("prevValue"));
                    result.append("\n\s\s")
                            .append("+").append(" ").append(diffInfo.get("key"))
                            .append(":").append(" ").append(diffInfo.get("currentValue"));
                }
                case "untouched" -> {
                    result.append("\n\s\s\s\s")
                            .append(diffInfo.get("key"))
                            .append(":").append(" ").append(diffInfo.get("currentValue"));
                }

                default -> {

                }
            }
        }

        result.append("\n}");

        return result.toString();
    }
}
