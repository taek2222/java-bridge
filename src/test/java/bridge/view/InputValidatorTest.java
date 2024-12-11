package bridge.view;

import static bridge.global.constant.ErrorMessage.INVALID_INPUT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 이동_입력이_아닌_경우_예외가_발생한다() {
        // given
        String input = "None";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateMove(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_INPUT.get());
    }

    @Test
    void 재시작_입력이_아닌_경우_예외가_발생한다() {
        // given
        String input = "None";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateRetryCommand(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_INPUT.get());
    }

}