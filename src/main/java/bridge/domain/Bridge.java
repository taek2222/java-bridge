package bridge.domain;

import bridge.domain.dto.BridgeResponse;
import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> answer;
    private final List<String> moves;

    public Bridge(final List<String> answer) {
        this.answer = answer;
        this.moves = new ArrayList<>();
    }

    public void addMoving(String moving) {
        moves.add(moving);
    }

    public boolean isWinner() {
        return isMaxMove() || isLastMoveEquals();
    }

    public boolean isPossible() {
        return !moves.isEmpty() && !isLastMoveEquals();
    }

    public boolean isMaxMove() {
        return answer.size() == moves.size();
    }

    private boolean isLastMoveEquals() {
        int lastIndex = moves.size() - 1;
        return moves.get(lastIndex).equals(answer.get(lastIndex));
    }

    public BridgeResponse createResponse() {
        return BridgeResponse.createResponse(answer, moves, isWinner());
    }

    public void clear() {
        moves.clear();
    }
}
