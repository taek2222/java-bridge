package bridge.view;

import static bridge.global.constant.MessageConstant.NEW_LINE;

import bridge.domain.dto.BridgeResponse;
import bridge.domain.dto.CountResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printTotalCount(CountResponse response) {
        System.out.printf("총 시도한 횟수: %d",  response.count());
    }

    public void printResult(BridgeResponse response) {
        System.out.println(NEW_LINE.get() + "최종 게임 결과");
        printMap(response);

        if (response.success()) {
            System.out.println(NEW_LINE.get() + "게임 성공 여부: 성공");
            return;
        }
        System.out.println(NEW_LINE.get() + "게임 성공 여부: 실패");
    }

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다." + NEW_LINE.get());
    }

    public void printMap(BridgeResponse response) {
        List<String> upMoves = response.upMoves();
        printBridge(upMoves);

        List<String> downMoves = response.downMoves();
        printBridge(downMoves);
    }

    private void printBridge(final List<String> moves) {
        String format = String.join(" | ", moves);
        System.out.println("[ " + format + " ]");
    }

    public void printErrorMessage(final String message) {
        System.out.println(message);
    }
}
