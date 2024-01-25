package hexlet.code.formatters;

import hexlet.code.DiffData;

import java.util.List;

public class Stylish {
    public static String format(List<DiffData> diffView) {
        StringBuilder result = new StringBuilder();


        String added = "\n  + %s: %s";
        String removed = "\n  - %s: %s";
        String updated = removed + added;
        String def = "\n    %s: %s";

        result.append("{");

        for (DiffData diffInfo: diffView) {
            switch (diffInfo.getOperation()) {
                case "added" -> result.append(String.format(added, diffInfo.getKey(), diffInfo.getCurrentValue()));
                case "removed" -> result.append(String.format(removed, diffInfo.getKey(), diffInfo.getCurrentValue()));
                case "updated" -> result.append(String.format(updated, diffInfo.getKey(),
                        diffInfo.getPrevValue(), diffInfo.getKey(), diffInfo.getCurrentValue()));
                case "default" -> result.append(String.format(def, diffInfo.getKey(), diffInfo.getCurrentValue()));
                default -> throw new RuntimeException("Unexpected operation: " + diffInfo.getOperation());
            }
        }

        result.append("\n}");

        return result.toString();
    }
}
