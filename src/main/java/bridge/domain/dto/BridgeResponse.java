package bridge.domain.dto;

import java.util.ArrayList;
import java.util.List;

public record BridgeResponse(
        List<String> upMoves,
        List<String> downMoves,
        boolean isSuccess
) {

    public static BridgeResponse createResponse(final List<String> answer, final List<String> moves, final boolean winner) {
            List<String> upMoves = new ArrayList<>();
            List<String> downMoves = new ArrayList<>();

            for (int index = 0; index < moves.size(); index++) {
                String bridge = evaluateMove(answer.get(index), moves.get(index));

                if (isIndexOfUp(moves.get(index))) {
                    upMoves.add(bridge);
                    downMoves.add(" ");
                    continue;
                }
                downMoves.add(bridge);
                upMoves.add(" ");
            }
            return new BridgeResponse(upMoves, downMoves, winner);
    }

    private static String evaluateMove(String answer, String move) {
        if (answer.equals(move))
            return "O";
        return "X";
    }

    private static boolean isIndexOfUp(final String move) {
        return move.equals("U");
    }
}
