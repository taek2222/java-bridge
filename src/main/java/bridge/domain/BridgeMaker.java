package bridge.domain;

import bridge.global.constant.ErrorMessage;
import bridge.global.util.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        validateBridgeSize(size);
        List<String> bridge = new ArrayList<>();
        for (int length = 0; length < size; length++) {
            bridge.add(generateBridge());
        }

        return bridge;
    }

    private String generateBridge() {
        if (bridgeNumberGenerator.generate() == 0) {
            return "D";
        }
        return "U";
    }

    private void validateBridgeSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_BRIDGE_SIZE_RANGE.get(3, 20));
        }
    }
}
