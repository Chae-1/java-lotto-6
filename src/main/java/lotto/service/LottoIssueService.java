package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoConsumer;
import lotto.util.ErrorMessages;

public class LottoIssueService {

    public LottoConsumer issueLottos(int issueCount) {
        validateIssueCount(issueCount);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < issueCount; i++) {
            lottos.add(new Lotto(getLottoNumbers()));
        }
        return new LottoConsumer(lottos);
    }

    private void validateIssueCount(int issueCount) {
        if (issueCount <= 0) {
            throw new IllegalArgumentException(ErrorMessages.ISSUE_COUNT_ERROR.getMessage());
        }
    }

    private List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public Lotto issueWinningLotto(List<Integer> winningNumber) {
        return new Lotto(winningNumber);
    }
}
