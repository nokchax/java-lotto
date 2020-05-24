package lotto.util;

import lotto.lotto.LottoTicket;
import lotto.lotto.LottoTickets;
import lotto.lotto.WinningNumbers;
import lotto.money.Money;
import lotto.money.PaymentInfo;
import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Generator {

    private Generator() {}

    public static List<LottoNumber> lottoNumberList(final int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public static LottoNumbers lottoNumbers(final int... numbers) {
        return LottoNumbers.init(lottoNumberList(numbers));
    }

    public static LottoTicket lottoTicket(final int... numbers) {
        return LottoTicket.init(lottoNumbers(numbers));
    }

    public static WinningNumbers winningLotto(final int... numbers) {
        return WinningNumbers.init(lottoNumbers(numbers));
    }

    public static LottoTickets lottoTickets(final LottoTicket... lottoTickets) {
        return LottoTickets.init(Arrays.asList(lottoTickets));
    }

    public static PaymentInfo paymentInfo(final int money) {
        Money payment = Money.of(money);

        return PaymentInfo.init(payment, Collections.emptyList());
    }
}
