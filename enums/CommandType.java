package enums;

public enum CommandType {
    INCREASE_AGE("increase age"),
    SET_NEW_SANTA_BUDGET("set new santa budget");

    public String type;

    CommandType(final String type) {
        this.type = type;
    }
}
