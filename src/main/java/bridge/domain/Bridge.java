package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> answer;
    private final List<String> moves;

    public Bridge(final List<String> answer) {
        this.answer = answer;
        this.moves = new ArrayList<>();
    }


}
