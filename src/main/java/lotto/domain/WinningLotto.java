package lotto.domain;

import java.util.List;

public class WinningLotto {

    private static final String ERROR_BONUS_DUPLICATION = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    private static final String ERROR_BONUS_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.";

    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new Lotto(winningNumbers); // Lotto에서 6개/중복/범위 검증
        validateBonusDuplication(bonusNumber);
        validateBonusRange(bonusNumber); // 💡 보너스 번호 범위 검사 추가
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusDuplication(int bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_DUPLICATION);
        }
    }

    // 💡 보너스 번호 범위 검사 메서드 추가
    private void validateBonusRange(int bonusNumber) {
        if (bonusNumber < Lotto.MIN_NUMBER || bonusNumber > Lotto.MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_BONUS_RANGE);
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}