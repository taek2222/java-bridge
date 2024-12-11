package bridge.domain.dto;

import java.util.List;

public record BridgeResponse(
        List<String> upMoves,
        List<String> downMoves,
        boolean isSuccess
) {
}
