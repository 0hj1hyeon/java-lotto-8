package lotto.view;

import lotto.domain.BuyingLottos;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public void printPurchaseCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void printLottoNumbers(BuyingLottos lottos) {
        for (Lotto lotto : lottos.getBuyingLottos()) {
            String numbersString = lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(numbersString);
        }
    }

    public void printStatistics(Map<LottoRank, Integer> statistics, double profitRate) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        LottoRank[] ranks = LottoRank.values();
        for (int i = ranks.length - 2; i >= 0; i--) {
            LottoRank rank = ranks[i];
            if (rank != LottoRank.MISS) {
                int count = statistics.getOrDefault(rank, 0);
                System.out.printf("%s - %d개%n", rank.getDescription(), count);
            }
        }

        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
