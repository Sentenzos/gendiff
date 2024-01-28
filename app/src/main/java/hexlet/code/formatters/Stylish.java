package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

import static hexlet.code.DiffView.Operation.ADDED;
import static hexlet.code.DiffView.Operation.UPDATED;
import static hexlet.code.DiffView.Operation.UNCHANGED;
import static hexlet.code.DiffView.Operation.REMOVED;

public class Stylish {
    public static String format(List<Map<String, Object>> diffView) {
        StringBuilder result = new StringBuilder();

        String added = "\n  + %s: %s";
        String removed = "\n  - %s: %s";
        String updated = removed + added;
        String def = "\n    %s: %s";

        result.append("{");

        for (Map<String, Object> diffInfo: diffView) {
            Object operation = diffInfo.get("operation");
            if (operation.equals(ADDED)) {
                result.append(String.format(added, diffInfo.get("key"), diffInfo.get("value")));
            } else if (operation.equals(REMOVED)) {
                result.append(String.format(removed, diffInfo.get("key"), diffInfo.get("value")));
            } else if (operation.equals(UPDATED)) {
                result.append(String.format(updated, diffInfo.get("key"),
                        diffInfo.get("value1"), diffInfo.get("key"), diffInfo.get("value2")));
            } else if (operation.equals(UNCHANGED)) {
                result.append(String.format(def, diffInfo.get("key"), diffInfo.get("value")));
            } else {
                throw new RuntimeException("Unexpected operation: " + diffInfo.get("operation"));
            }
        }

        result.append("\n}");

        return result.toString();
    }
}
