package bridge.global.validation;

import bridge.global.constant.ErrorMessage;

public class CommonValidator {

    public static void validateIsNumeric(String input) { //
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC.get());
        }
    }
}
