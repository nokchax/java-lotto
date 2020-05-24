package lotto.lotto;

import lotto.dto.LottoTicketDto;
import lotto.match.MatchResult;
import lotto.money.Money;
import lotto.prize.LottoPrize;

import java.util.List;
import java.util.Map;

public class Lotto {
    private final Money paymentMoney;
    private final LottoTickets lottoTickets;

    private Lotto(final Money payment, final LottoTickets lottoTickets) {
        validate(lottoTickets);

        this.paymentMoney = payment;
        this.lottoTickets = lottoTickets;
    }

    private void validate(final LottoTickets lottoTickets) {
        if (lottoTickets == null) {
            throw new IllegalArgumentException("LottoTickets can't be a null");
        }
    }

    public static Lotto init(final Money payment, final LottoTickets lottoTickets) {
        return new Lotto(payment, lottoTickets);
    }

    public List<LottoTicketDto> getLottoTickets() {
        return lottoTickets.getLottoTickets();
    }

    public MatchResult match(final WinningNumbers winningNumbers) {
        Map<LottoPrize, Long> lottoPrizes = lottoTickets.matchLottoNumbers(winningNumbers);

        return MatchResult.init(paymentMoney, lottoPrizes);
    }
}
