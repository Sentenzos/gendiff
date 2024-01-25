package hexlet.code;

public class DiffData {
    private String key;
    private String operation;
    private Object currentValue;
    private Object prevValue;

    public DiffData(String key, String operation, Object currentValue, Object prevValue) {
        this.key = key;
        this.operation = operation;
        this.currentValue = currentValue;
        this.prevValue = prevValue;
    }

    public DiffData(String key, String operation, Object currentValue) {
        this.key = key;
        this.operation = operation;
        this.currentValue = currentValue;
    }

    public String getKey() {
        return key;
    }

    public String getOperation() {
        return operation;
    }

    public Object getCurrentValue() {
        return currentValue;
    }

    public Object getPrevValue() {
        return prevValue;
    }
}
