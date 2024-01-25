package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DiffView {
    public static List<DiffData> get(List<String> keyList, Map<String, Object> map1, Map<String, Object> map2) {
        List<DiffData> diffDataList = new ArrayList<>();

        for (String key: keyList) {
            if (!map1.containsKey(key)) {
                diffDataList.add(new DiffData(key, "added", map2.get(key)));
            } else if (!map2.containsKey(key)) {
                diffDataList.add(new DiffData(key, "removed", map1.get(key)));
            } else if ((map1.get(key) == null && map2.get(key) != null) || !map1.get(key).equals(map2.get(key))) {
                diffDataList.add(new DiffData(key, "updated", map2.get(key), map1.get(key)));
            } else {
                diffDataList.add(new DiffData(key, "default", map1.get(key)));
            }
        }

        return diffDataList;
    }
}
