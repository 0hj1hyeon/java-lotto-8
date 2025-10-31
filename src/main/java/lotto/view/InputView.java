package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchaseAmount;

import java.util.List;

public class InputView {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public PurchaseAmount readPurchaseAmount(){
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                String input = Console.readLine();
                int amountValue = Integer.parseInt(input.trim());
                return new PurchaseAmount(amountValue);

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입 금액은 숫자 형식이어야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> readWinningNumbers() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                return parseNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
