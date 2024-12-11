package bridge.view;

import static bridge.global.constant.ErrorMessage.INVALID_INPUT;

import bridge.global.constant.ErrorMessage;

public class InputValidator {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";

    protected static void validateMove(String input) {
        if (!input.equals(UP) && !input.equals(DOWN)) {
            throw new IllegalArgumentException(INVALID_INPUT.get());
        }
    }

    protected static void validateRetryCommand(String input) {
        if (!input.equals(RETRY) && !input.equals(QUIT)) {
            throw new IllegalArgumentException(INVALID_INPUT.get());
        }
    }

    protected static void validateIsNumeric(String input) { //
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC.get());
        }
    }
}
