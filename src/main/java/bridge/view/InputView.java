package bridge.view;

import static bridge.global.constant.MessageConstant.NEW_LINE;

import bridge.global.constant.ErrorMessage;
import bridge.global.validation.CommonValidator;
import camp.nextstep.edu.missionutils.Console;

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

    public boolean readRetryCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        String input = Console.readLine().toUpperCase();
        validateRetryCommand(input);
        return input.equals("R");
    }

    private void validateMove(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.get());
        }
    }

    private void validateRetryCommand(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.get());
        }
    }
}
