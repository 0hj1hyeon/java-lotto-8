package lotto.Controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void start() {
        // 1. 구입 금액 입력 및 유효성 검사 (PurchaseAmount 객체 생성)
        PurchaseAmount purchaseAmount = inputView.readPurchaseAmount();
        int lottoCount = purchaseAmount.getLottoCount();

        // 2. 로또 발행 (Lottos 객체 생성)
        List<Lotto> purchasedLottos = lottoGenerator.generateLottos(lottoCount);
        BuyingLottos userLottos = new BuyingLottos(purchasedLottos);

        // 3. 구입 결과 출력
        outputView.printPurchaseCount(userLottos.getCount());
        outputView.printLottoNumbers(userLottos);

        // 4. 당첨 번호 및 보너스 번호 입력
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber();

        // 5. WinningLotto 객체 생성 및 최종 유효성 검사
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        // 6. 당첨 통계 계산
        LottoStatistic statistic = new LottoStatistic(userLottos, winningLotto, purchaseAmount);

        // 7. 결과 출력
        outputView.printStatistics(statistic.getStatistics(), statistic.calculateProfitRate());
    }
}