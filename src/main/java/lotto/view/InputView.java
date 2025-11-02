package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchaseAmount;
import lotto.domain.Lotto; // Lotto 검증을 위해 import

import java.util.List;

public class InputView {


    public PurchaseAmount readPurchaseAmount() {
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
                List<Integer> numbers = parseNumbers(input);
                new Lotto(numbers);
                return numbers;

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 당첨 번호는 모두 숫자 형식이어야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> parseNumbers(String input) {
        String[] parts = input.split(",");

        return java.util.stream.Stream.of(parts)
                .map(String::trim)
                .map(s -> {
                    try {
                        int number = Integer.parseInt(s);
                        return number;
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException();
                    }
                })
                .collect(java.util.stream.Collectors.toList());
    }

    public int readBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                return parseBonus(input);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 숫자 형식이어야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseBonus(String input) {
        int number = Integer.parseInt(input.trim());
        return number;
    }
}