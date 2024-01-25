package hexlet.code.formatters;

import hexlet.code.DiffData;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String format(List<DiffData> diffView) {
        StringBuilder result = new StringBuilder();

        String added = "Property '%s' was added with value: %s\n";
        String removed = "Property '%s' was removed\n";
        String updated = "Property '%s' was updated. From %s to %s\n";

        for (DiffData diffInfo: diffView) {
            switch (diffInfo.getOperation()) {
                case "added" -> result.append(String.format(
                        added,
                        diffInfo.getKey(),
                        stringify(diffInfo.getCurrentValue())
                ));
                case "removed" -> result.append(String.format(
                        removed,
                        diffInfo.getKey()
                ));
                case "updated" -> result.append(String.format(
                        updated,
                        diffInfo.getKey(),
                        stringify(diffInfo.getPrevValue()),
                        stringify(diffInfo.getCurrentValue())
                ));
                case "default" -> {

                }
                default -> throw new RuntimeException("Unexpected operation: " + diffInfo.getOperation());
            }
        }

        return result.toString().trim();
    }

    private static String stringify(Object object) {
        if (object instanceof Map || object instanceof List) {
            return "[complex value]";
        } else if (object instanceof String) {
            return "'" + object + "'";
        }
        return String.valueOf(object);
    }
}
