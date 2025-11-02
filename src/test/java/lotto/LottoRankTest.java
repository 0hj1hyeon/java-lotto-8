package lotto;

import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @DisplayName("6개 일치 시 1등을 반환한다.")
    @Test
    void match_6_returns_FIRST() {
        LottoRank rank = LottoRank.valueOf(6, false);
        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("5개 일치 + 보너스 일치 시 2등을 반환한다.")
    @Test
    void match_5_bonus_returns_SECOND() {
        LottoRank rank = LottoRank.valueOf(5, true);
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("5개 일치 + 보너스 불일치 시 3등을 반환한다.")
    @Test
    void match_5_no_bonus_returns_THIRD() {
        LottoRank rank = LottoRank.valueOf(5, false);
        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("4개 일치 시 4등을 반환한다.")
    @Test
    void match_4_returns_FOURTH() {
        LottoRank rank = LottoRank.valueOf(4, false);
        assertThat(rank).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("3개 일치 시 5등을 반환한다.")
    @Test
    void match_3_returns_FIFTH() {
        LottoRank rank = LottoRank.valueOf(3, false);
        assertThat(rank).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("2개 이하 일치 시 낙첨(MISS)을 반환한다.")
    @Test
    void match_less_than_3_returns_MISS() {
        LottoRank rank = LottoRank.valueOf(2, true);
        assertThat(rank).isEqualTo(LottoRank.MISS);
    }
}
