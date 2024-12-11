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

    public void clear() {
        moves.clear();
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
        List<String> upMoves = new ArrayList<>();
        List<String> downMoves = new ArrayList<>();

        for (int index = 0; index < moves.size(); index++) {
            String bridge = checkBridge(answer.get(index), moves.get(index));

            if (moves.get(index).equals("U")) {
                upMoves.add(bridge);
                downMoves.add(" ");
                continue;
            }

            downMoves.add(bridge);
            upMoves.add(" ");
        }
        return new BridgeResponse(upMoves, downMoves, isWinner());
    }

    private String checkBridge(String answer, String move) {
        if (answer.equals(move))
            return "O";
        return "X";
    }
}
