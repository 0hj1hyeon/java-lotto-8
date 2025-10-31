package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoStatistic {

    private final Map<LottoRank, Integer> statistics;
    private final int purchaseAmount;

    public LottoStatistic(BuyingLottos userLottos, WinningLotto winningLotto, PurchaseAmount purchaseAmount) {
        this.statistics = new EnumMap<>(LottoRank.class);
        this.purchaseAmount = purchaseAmount.getAmount();
        initializeStatistics();
        calculateStatistics(userLottos, winningLotto);
    }

    private void initializeStatistics() {
        for (LottoRank rank : LottoRank.values()) {
            statistics.put(rank, 0);
        }
    }

    private void calculateStatistics(BuyingLottos userLottos, WinningLotto winningLotto) {
        for (Lotto userLotto : userLottos.getBuyingLottos()) {

            LottoMatchResult result = userLotto.match(winningLotto);
            LottoRank rank = LottoRank.valueOf(result.getMatchCount(), result.isMatchBonus());
            statistics.put(rank, statistics.get(rank) + 1);
        }
    }

    public double calculateProfitRate() {
        long totalPrize = statistics.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();

        double rate = (double) totalPrize / purchaseAmount * 100;
        return Math.round(rate * 10.0) / 10.0;
    }

    public Map<LottoRank, Integer> getStatistics() {
        return Collections.unmodifiableMap(statistics);
    }
}
