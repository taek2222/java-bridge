package bridge.global.constant;

public enum MessageConstant {
    // Output
    OUTPUT_GAME_START("다리 건너기 게임을 시작합니다."),
    OUTPUT_RESULT("최종 게임 결과"),
    OUTPUT_BRIDGE("[ %s ]"),
    OUTPUT_GAME_SUCCESS_WHETHER("게임 성공 여부: %s"),
    OUTPUT_TOTAL_COUNT("총 시도한 횟수: %d"),

    // Input
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RETRY_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),

    NEW_LINE(System.lineSeparator())
    ;

    private final String message;

    MessageConstant(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

    public String get(Object... value) {
        return String.format(message, value);
    }
}