package lotto.domain;

public class PurchaseAmount {


    private static final int LOTTO_PRICE = 1000;

    private static final String ERROR_NOT_POSITIVE = "[ERROR] 구입 금액은 0보다 커야 합니다.";
    private static final String ERROR_NOT_DIVISIBLE = "[ERROR] 구입 금액은 " + LOTTO_PRICE + "원 단위로 나누어 떨어져야 합니다.";

    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        validatePositive(amount);
        validateDivisibleByLottoPrice(amount);
    }

    private void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ERROR_NOT_POSITIVE);
        }
    }

    private void validateDivisibleByLottoPrice(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_NOT_DIVISIBLE);
        }
    }

    public int getLottoCount() {
        return this.amount / LOTTO_PRICE;
    }

    public int getAmount() {
        return amount;
    }
}
