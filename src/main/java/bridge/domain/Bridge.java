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
        return isMaxMoving() && isLastMoveEquals();
    }

    public boolean isPossible() {
        if (moves.isEmpty())
            return true;

        if (isMaxMoving()) {
            return false;
        }

        return isLastMoveEquals();
    }

    public void clear() {
        moves.clear();
    }

    public BridgeResponse createResponse() {
        return BridgeResponse.createResponse(answer, moves, isWinner());
    }

    private boolean isMaxMoving() {
        return answer.size() == moves.size();
    }

    private boolean isLastMoveEquals() {
        int lastIndex = moves.size() - 1;
        return moves.get(lastIndex).equals(answer.get(lastIndex));
    }
}
