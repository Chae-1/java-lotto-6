package lotto.domain;

import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> issuedLottos;

    public Lottos(List<Lotto> issuedLottos) {
        this.issuedLottos = issuedLottos;
    }

    public ResultStatics calculateResult(LottoResult lottoResult) {
        Map<LottoPrizeStatus, Integer> prizeResult = lottoResult.mappingPrizeResult(issuedLottos);
        int issueCount = issuedLottos.size();
        return new ResultStatics(prizeResult, issueCount);
    }

    public List<Lotto> getIssuedLottos() {
        return issuedLottos;
    }
}