package lotto.domain;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원)"),
    MISS(0, false, 0, "낙첨");

    private final int matchCount;
    private final boolean matchBonus;
    private final long prizeMoney;
    private final String description;

    LottoRank(int matchCount, boolean matchBonus, long prizeMoney, String description) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount < 3) {
            return MISS;
        }

        if (matchCount == 5) {
            if (matchBonus) {
                return SECOND;
            }
            return THIRD;
        }

        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && rank != SECOND && rank != THIRD) {
                return rank;
            }
        }
        return MISS;
    }
}