package bridge.view;

import static bridge.global.constant.MessageConstant.NEW_LINE;
import static bridge.global.constant.MessageConstant.OUTPUT_BRIDGE;
import static bridge.global.constant.MessageConstant.OUTPUT_GAME_START;
import static bridge.global.constant.MessageConstant.OUTPUT_GAME_SUCCESS_WHETHER;
import static bridge.global.constant.MessageConstant.OUTPUT_RESULT;
import static bridge.global.constant.MessageConstant.OUTPUT_TOTAL_COUNT;

import bridge.domain.dto.BridgeResponse;
import bridge.domain.dto.CountResponse;
import java.util.List;

public class OutputView {

    private static final String BRIDGE_DELIMITER = " | ";
    private static final String SUCCESS_MESSAGE = "성공";
    private static final String FAIL_MESSAGE = "실패";

    public void printGameStart() {
        System.out.println(OUTPUT_GAME_START.get() + NEW_LINE.get());
    }

    public void printMap(BridgeResponse response) {
        List<String> upMoves = response.upMoves();
        printBridge(upMoves);

        List<String> downMoves = response.downMoves();
        printBridge(downMoves);
    }

    public void printResult(BridgeResponse response) {
        System.out.println(NEW_LINE.get() + OUTPUT_RESULT.get());
        printMap(response);

        if (response.isSuccess()) {
            printGameSuccessWhether(SUCCESS_MESSAGE);
            return;
        }
        printGameSuccessWhether(FAIL_MESSAGE);
    }

    public void printErrorMessage(final String message) {
        System.out.println(message);
    }

    public void printTotalCount(CountResponse response) {
        System.out.printf(OUTPUT_TOTAL_COUNT.get(response.count()));
    }

    private void printBridge(final List<String> moves) {
        String format = String.join(BRIDGE_DELIMITER, moves);
        System.out.println(OUTPUT_BRIDGE.get(format));
    }

    private void printGameSuccessWhether(String whether) {
        System.out.printf(NEW_LINE.get() + OUTPUT_GAME_SUCCESS_WHETHER.get(whether));
        System.out.printf(NEW_LINE.get());
    }
}
