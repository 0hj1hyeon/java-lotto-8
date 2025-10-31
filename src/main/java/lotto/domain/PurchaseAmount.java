package lotto.domain;

public class PurchaseAmount {

    private static final String ERROR_NOT_POSITIVE = "[ERROR] 구입 금액은 0보다 커야 합니다.";

    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        validatePositive(amount);
    }

    private void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ERROR_NOT_POSITIVE);
        }
    }
}
