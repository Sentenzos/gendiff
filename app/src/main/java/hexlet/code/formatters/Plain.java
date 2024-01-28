package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

import static hexlet.code.DiffView.Operation.ADDED;
import static hexlet.code.DiffView.Operation.UPDATED;
import static hexlet.code.DiffView.Operation.REMOVED;

public class Plain {
    public static String format(List<Map<String, Object>> diffView) {
        StringBuilder result = new StringBuilder();

        String added = "Property '%s' was added with value: %s\n";
        String removed = "Property '%s' was removed\n";
        String updated = "Property '%s' was updated. From %s to %s\n";

        for (Map<String, Object> diffInfo: diffView) {
            Object operation = diffInfo.get("operation");
            if (operation.equals(ADDED)) {
                result.append(String.format(
                        added,
                        diffInfo.get("key"),
                        stringify(diffInfo.get("value"))
                ));
            } else if (operation.equals(REMOVED)) {
                result.append(String.format(
                        removed,
                        diffInfo.get("key")
                ));
            } else if (operation.equals(UPDATED)) {
                result.append(String.format(
                        updated,
                        diffInfo.get("key"),
                        stringify(diffInfo.get("value1")),
                        stringify(diffInfo.get("value2"))
                ));
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
