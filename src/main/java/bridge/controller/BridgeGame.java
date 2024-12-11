package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.Count;
import bridge.domain.dto.BridgeResponse;
import bridge.global.util.BridgeNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeGame(final InputView inputView,
                      final OutputView outputView,
                      final BridgeNumberGenerator bridgeNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public void run() {
        displayGameStartMessage();
        Count count = new Count();

        Bridge bridge = createBridge();

        do {
            bridge.clear();
            count.increment();
            processGame(bridge);

            if (bridge.isWinner()) {
                break;
            }
        } while (retry());
        displayResult(bridge, count);
    }

    private void displayResult(final Bridge bridge, final Count count) {
        outputView.printResult(bridge.createResponse());
        outputView.printTotalCount(count.createResponse());
    }

    private void processGame(Bridge bridge) {
        while (bridge.isPossible()) {
            move(bridge);

            BridgeResponse response = bridge.createResponse();
            outputView.printMap(response);
        }
    }

    private Bridge createBridge() {
        List<String> bridge = initializeBridge();
        return new Bridge(bridge);
    }

    private void move(final Bridge bridge) {
        while(true) {
            try {
                String moving = inputView.readMoving();
                bridge.addMoving(moving);
                return;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
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

    private boolean retry() {
        while(true) {
            try {
                return inputView.readRetryCommand();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void displayGameStartMessage() {
        outputView.printGameStart();
    }
}
