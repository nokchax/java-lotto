package lotto;

import lotto.match.MatchResult;
import lotto.lotto.Lotto;
import lotto.lotto.LottoSeller;
import lotto.lotto.WinningNumbers;
import lotto.money.Money;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

import java.util.List;

public class LottoGame {
    public static void main(String[] args) {
        Money payment = Money.of(ConsoleInput.inputPayment());

        Lotto lotto = LottoSeller.buy(payment);
        ConsoleOutput.showLottoTickets(lotto.getLottoTickets());

        List<Integer> winningNumbers = ConsoleInput.inputWinningLottoNumber();
        MatchResult matchResult = lotto.match(WinningNumbers.init(winningNumbers));

        ConsoleOutput.showMatchResult(matchResult);
    }
}
