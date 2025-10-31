package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

public class LottoGenerator {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public List<Integer> generateRandomLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LOTTO_MIN_NUMBER,
                LOTTO_MAX_NUMBER,
                LOTTO_NUMBER_COUNT
        );
        return numbers;
    }

    public List<Lotto> generateLottos(int lottoCount) {
        return java.util.stream.IntStream.range(0, lottoCount)
                .mapToObj(i -> {
                    List<Integer> randomNumbers = generateRandomLottoNumbers();
                    return new Lotto(randomNumbers);
                })
                .collect(Collectors.toList());
    }
}