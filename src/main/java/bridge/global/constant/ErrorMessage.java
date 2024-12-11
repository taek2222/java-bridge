package bridge.global.constant;

public enum ErrorMessage {
    INVALID_INPUT("유효 하지 않은 입력 입니다."),
//    INVALID_FORMAT("입력값의 형식이 잘못되었습니다."),
    OUT_OF_BRIDGE_SIZE_RANGE("다리 길이는 %d부터 %d 사이의 숫자여야 합니다."),
//    INVALID_LENGTH("입력값의 길이가 잘못되었습니다. (%d ~ %d자)"),
//    DUPLICATE_ENTRY("중복된 값이 존재합니다."),
    INVALID_NUMERIC("숫자만 입력 가능합니다."),
    ;

    private static final String PREFIX = "[ERROR] ";
    private static final String RETRY = " 다시 입력해 주세요.";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return PREFIX + message + RETRY;
    }

    public String get(Object... value) {
        return PREFIX + String.format(message, value) + RETRY;
    }
}