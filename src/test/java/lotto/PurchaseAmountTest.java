package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1200, 500, 1001, 0})
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다(int invalidAmount) {
        assertThatThrownBy(() -> new PurchaseAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0보다 작거나 같으면 예외가 발생한다.")
    @Test
    void 구입_금액이_0이하면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 따른 로또 개수를 정확히 계산한다.")
    @Test
    void 구입_금액에_따른_로또_개수_계산() {
        PurchaseAmount amount = new PurchaseAmount(8000);
        assertThat(amount.getLottoCount()).isEqualTo(8);
    }
}