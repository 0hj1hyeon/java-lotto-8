package lotto;


import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    private final List<Integer> VALID_WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);

    @DisplayName("보너스 번호가 당첨 번호 6개 중 하나와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        int duplicateBonusNumber = 3;

        assertThatThrownBy(() -> new WinningLotto(VALID_WINNING_NUMBERS, duplicateBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 보너스_번호_범위를_벗어나면_예외가_발생한다(int invalidBonusNumber) {
        assertThatThrownBy(() -> new WinningLotto(VALID_WINNING_NUMBERS, invalidBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개 미만이면 Lotto 객체 생성 시 예외가 발생한다.")
    @Test
    void 당첨_번호가_6개_미만이면_예외가_발생한다() {
        List<Integer> lessThanSix = List.of(1, 2, 3, 4, 5);
        int validBonus = 45;

        assertThatThrownBy(() -> new WinningLotto(lessThanSix, validBonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
