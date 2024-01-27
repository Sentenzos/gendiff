package hexlet.code;

public class DiffData {

    public enum Operation {
        REMOVED,
        ADDED,
        UNCHANGED,
        UPDATED
    }

    private String key;
    private Operation operation;
    private Object currentValue;
    private Object prevValue;

    /**
     * @param key
     * @param operation
     * @param currentValue
     * @param prevValue
     */
    public DiffData(String key, Operation operation, Object currentValue, Object prevValue) {
        this.key = key;
        this.operation = operation;
        this.currentValue = currentValue;
        this.prevValue = prevValue;
    }

    /**
     * @param key
     * @param operation
     * @param currentValue
     */
    public DiffData(String key, Operation operation, Object currentValue) {
        this.key = key;
        this.operation = operation;
        this.currentValue = currentValue;
    }

    /**
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     * @return operation
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     * @return currentValue
     */
    public Object getCurrentValue() {
        return currentValue;
    }

    /**
     * @return prevValue
     */
    public Object getPrevValue() {
        return prevValue;
    }
}
