package lotto.money;

import java.util.List;

public class PaymentInfo {
    private final Money payment;
    private final List<Integer> lottoNumbers;

    private PaymentInfo(final Money payment, final List<Integer> lottoNumbers) {
        this.payment = payment;
        this.lottoNumbers = lottoNumbers;
    }

    public PaymentInfo init(final Money payment, final List<Integer> lottoNumbers) {
        return new PaymentInfo(payment, lottoNumbers);
    }
}
