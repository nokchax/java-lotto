package lotto.lotto;

import lotto.money.Money;
import lotto.number.LottoNumbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoSeller {
    public static final int PRICE_OF_A_TICKET_VALUE = 1000;
    public static final Money PRICE_OF_A_TICKET = Money.of(PRICE_OF_A_TICKET_VALUE);
    private static final int ZERO = 0;

    private LottoSeller() {}

    public static Lotto buy(final Money payment) {
        LottoTickets lottoTickets = LottoTickets.init(buyAutoLottoTickets(payment));

        return Lotto.init(payment, lottoTickets);
    }

    private static List<LottoTicket> buyAutoLottoTickets(final Money payment) {
        return Stream.generate(LottoSeller::generateAuto)
                .limit(payment.getAffordableCount(PRICE_OF_A_TICKET))
                .collect(Collectors.toList());
    }

    private static LottoTicket generateAuto() {
        return LottoTicket.init(LottoNumbers.auto());
    }
}
