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

        PurchaseAmount purchaseAmount = inputView.readPurchaseAmount();
        int lottoCount = purchaseAmount.getLottoCount();


        List<Lotto> purchasedLottos = lottoGenerator.generateLottos(lottoCount);
        BuyingLottos userLottos = new BuyingLottos(purchasedLottos);


        outputView.printPurchaseCount(userLottos.getCount());
        outputView.printLottoNumbers(userLottos);


        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber();


        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);


        LottoStatistic statistic = new LottoStatistic(userLottos, winningLotto, purchaseAmount);


        outputView.printStatistics(statistic.getStatistics(), statistic.calculateProfitRate());
    }
}