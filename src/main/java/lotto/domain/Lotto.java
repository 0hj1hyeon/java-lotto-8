package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final int LOTTO_NUMBER_COUNT = 6;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        validateDuplication(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateDuplication(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    public LottoMatchResult match(WinningLotto winningLotto) {
        int matchCount = calculateMatchCount(winningLotto.getWinningNumbers());
        boolean matchBonus = calculateBonusMatch(winningLotto.getBonusNumber(), matchCount);

        return new LottoMatchResult(matchCount, matchBonus);
    }

    private int calculateMatchCount(List<Integer> winningNumbers) {
        int count = 0;
        for (int number : this.numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean calculateBonusMatch(int bonusNumber, int matchCount) {
        if (matchCount == 5 && this.numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}
