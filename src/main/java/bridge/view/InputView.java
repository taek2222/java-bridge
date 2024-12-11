package bridge.view;

import static bridge.global.constant.MessageConstant.INPUT_BRIDGE_SIZE;
import static bridge.global.constant.MessageConstant.INPUT_MOVING;
import static bridge.global.constant.MessageConstant.INPUT_RETRY_COMMAND;
import static bridge.global.constant.MessageConstant.NEW_LINE;
import static bridge.view.InputValidator.validateIsNumeric;
import static bridge.view.InputValidator.validateMove;
import static bridge.view.InputValidator.validateRetryCommand;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String RETRY_COMMAND = "R";

    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE.get());

        String input = Console.readLine();
        validateIsNumeric(input);
        return Integer.parseInt(input);
    }

    public String readMoving() {
        System.out.println(NEW_LINE.get() + INPUT_MOVING.get());

        String input = Console.readLine().toUpperCase();
        validateMove(input);
        return input;
    }

    public boolean readRetryCommand() {
        System.out.println(INPUT_RETRY_COMMAND.get());

        String input = Console.readLine().toUpperCase();
        validateRetryCommand(input);
        return input.equals(RETRY_COMMAND);
    }
}
