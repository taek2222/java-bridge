package bridge.view;

import static bridge.global.constant.MessageConstant.NEW_LINE;

import bridge.global.constant.ErrorMessage;
import bridge.global.validation.CommonValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();

        CommonValidator.validateIsNumeric(input);
        return Integer.parseInt(input);
    }

    public String readMoving() {
        System.out.println(NEW_LINE.get() + "이동할 칸을 선택해주세요. (위: U, 아래: D)");

        String input = Console.readLine().toUpperCase();
        validateMove(input);
        return input;
    }

    public String readGameCommand() {
        return null;
    }

    private void validateMove(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.get());
        }
    }
}
