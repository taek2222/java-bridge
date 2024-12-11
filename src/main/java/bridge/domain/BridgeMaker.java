package bridge.domain;

import static bridge.global.constant.ErrorMessage.OUT_OF_BRIDGE_SIZE_RANGE;

import bridge.global.util.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private static final int MINIMUM_SIZE = 3;
    private static final int MAXIMUM_SIZE = 20;
    private static final int BRIDGE_DOWN_NUMBER = 0;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        validateBridgeSize(size);
        List<String> bridge = new ArrayList<>();

        for (int length = 0; length < size; length++) {
            bridge.add(generateBridgeSegment());
        }

        return bridge;
    }

    private void validateBridgeSize(int size) {
        if (size < MINIMUM_SIZE || size > MAXIMUM_SIZE) {
            throw new IllegalArgumentException(
                    OUT_OF_BRIDGE_SIZE_RANGE
                            .get(MINIMUM_SIZE, MAXIMUM_SIZE));
        }
    }

    private String generateBridgeSegment() {
        if (bridgeNumberGenerator.generate() == BRIDGE_DOWN_NUMBER) {
            return "D";
        }
        return "U";
    }
}
