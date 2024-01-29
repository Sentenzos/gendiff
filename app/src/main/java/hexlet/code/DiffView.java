package hexlet.code;

import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.ArrayList;

public class DiffView {
    public enum Operation {
        REMOVED,
        ADDED,
        UNCHANGED,
        UPDATED
    }

    public static List<Map<String, Object>> get(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> keySet = new TreeSet<>(map1.keySet());
        keySet.addAll(map2.keySet());
        List<Map<String, Object>> diffDataList = new ArrayList<>();

        for (String key: keySet) {
            Map<String, Object> line = new HashMap<>();
            line.put("key", key);

            if (!map1.containsKey(key)) {
                line.put("operation", Operation.ADDED);
                line.put("value", map2.get(key));
            } else if (!map2.containsKey(key)) {
                line.put("operation", Operation.REMOVED);
                line.put("value", map1.get(key));
            } else if ((map1.get(key) == null && map2.get(key) != null) || !map1.get(key).equals(map2.get(key))) {
                line.put("operation", Operation.UPDATED);
                line.put("value1", map1.get(key));
                line.put("value2", map2.get(key));
            } else {
                line.put("operation", Operation.UNCHANGED);
                line.put("value", map1.get(key));
            }
            diffDataList.add(line);
        }
        return diffDataList;
    }
}
