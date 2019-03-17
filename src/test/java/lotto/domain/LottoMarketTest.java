package lotto.domain;

import lotto.dto.Lotto;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMarketTest {
    @Test
    public void 로또번호생성() {
        List<Integer> numbers = LottoMarket.createNumbers();
        assertThat(numbers).hasSize(6);
    }

    @Test
    public void 로또번호검증() {
        List<Integer> numbers = LottoMarket.createNumbers();
        Collections.sort(numbers);
        assertThat(numbers.get(0)).isGreaterThan(0);
        assertThat(numbers.get(5)).isLessThanOrEqualTo(45);
    }

    @Test
    public void 로또구입() {
        List<Lotto> lottos = LottoMarket.createLottos(10);
        assertThat(lottos).hasSize(10);
    }
}