package lotto.view;

import lotto.domain.BuyingLottos;
import lotto.domain.Lotto;

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
}
