package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.DiffData;

import java.util.List;

public class Formatter {
    public static String format(List<DiffData> diffView, String format) throws JsonProcessingException {

        if (format.equals("stylish")) {
            return Stylish.format(diffView);
        } else if (format.equals("plain")) {
            return Plain.format(diffView);
        } else if (format.equals("json")) {
            return Json.format(diffView);
        }

        return "";
    }
}
