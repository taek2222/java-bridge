package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.global.constant.ErrorMessage;
import bridge.global.util.BridgeRandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    @Test
    void 다리_전진이_계속_가능하면_TRUE를_반환한다() {
        // given
        String up = "U";
        String down = "D";
        List<String> answer = List.of(up, down, down);

        Bridge bridge = new Bridge(answer);
        bridge.addMoving(up);
        bridge.addMoving(down);

        // when
        boolean result = bridge.isPossible();

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 다리_전진이_불가능하면_FALSE를_반환한다() {
        // given
        String up = "U";
        String down = "D";
        List<String> answer = List.of(up, down, down);

        Bridge bridge = new Bridge(answer);
        bridge.addMoving(up);
        bridge.addMoving(down);
        bridge.addMoving(down);

        // when
        boolean result = bridge.isPossible();

        // then
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 21})
    void 범위에_벗어난_길이인_경우_예외가_발생한다(int size) {
        // given
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());

        // when & then
        assertThatThrownBy(() -> maker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUT_OF_BRIDGE_SIZE_RANGE.get(3, 20));
    }
}