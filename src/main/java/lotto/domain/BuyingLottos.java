package lotto.domain;

import java.util.List;
import java.util.Collections;

public class BuyingLottos {

    private final List<Lotto> BuyingLottos;

    public BuyingLottos(List<Lotto> BuyingLottos) {
        this.BuyingLottos = BuyingLottos;
    }

    public int getCount() {
        return BuyingLottos.size();
    }

    public List<Lotto> getBuyingLottos() {
        return Collections.unmodifiableList(BuyingLottos);
    }
}
