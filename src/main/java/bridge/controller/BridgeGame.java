package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.dto.BridgeResponse;
import bridge.global.util.BridgeNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeGame(final InputView inputView, final OutputView outputView,
                      final BridgeNumberGenerator bridgeNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public void run() {
        displayGameStartMessage();

        Bridge bridge = createBridge();

        String moving = inputView.readMoving();
        bridge.addMoving(moving);

        BridgeResponse response = bridge.createResponse();
        outputView.printMap(response);
    }

    private Bridge createBridge() {
        List<String> bridge = initializeBridge();
        return new Bridge(bridge);
    }

    private List<String> initializeBridge() {
        while(true) {
            try {
                int bridgeSize = inputView.readBridgeSize();
                BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
                return bridgeMaker.makeBridge(bridgeSize);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    private void displayGameStartMessage() {
        outputView.printGameStart();
    }
}
