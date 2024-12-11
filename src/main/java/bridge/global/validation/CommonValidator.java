package bridge.global.validation;

import bridge.global.constant.ErrorMessage;

public class CommonValidator {

    public static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsNumeric(String input) { //
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC.get());
        }
    }

    public static void validateRange(int value, int min, int max) {
        if (value < min || value > max) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateLength(String input, int minLen, int maxLen) {
        int length = input.length();
        if (length < minLen || length > maxLen) {
            throw new IllegalArgumentException();
        }
    }
}
