package lotto.domain;

import java.util.List;

public class WinningLotto {

    private static final String ERROR_BONUS_DUPLICATION = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new Lotto(winningNumbers);
        validateBonusDuplication(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusDuplication(int bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_DUPLICATION);
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
