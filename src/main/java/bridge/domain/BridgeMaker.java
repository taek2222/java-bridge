package bridge.domain;

import bridge.global.util.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
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
}
