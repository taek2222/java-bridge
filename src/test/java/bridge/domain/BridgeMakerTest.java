package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.global.constant.ErrorMessage;
import bridge.global.util.BridgeRandomNumberGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

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