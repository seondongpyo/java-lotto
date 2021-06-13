package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LotteriesTest {

    public static final List<LotteryNumbers> TEST_LOTTERY_NUMBERS = List.of(
            new LotteryNumbers(List.of(10, 15, 24, 39, 40, 45)),
            new LotteryNumbers(List.of(1, 2, 3, 4, 5, 6))
    );

    @Test
    @DisplayName("입력한 개수만큼 로또를 생성한다.")
    void generateLotteries_test() {
        //when
        Lotteries lotteries = new Lotteries(new GenerateCount(5), new MockNumberGenerator());

        //then
        assertThat(lotteries.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("자동 로또 생성 개수만큼 생성한 것과 수동 로또를 합친 로또 번호들을 생성한다.")
    void generateAutoAndManualLotteries_test() {
        //when
        Lotteries lotteries = new Lotteries(new GenerateCount(5), new MockNumberGenerator(), TEST_LOTTERY_NUMBERS);

        //then
        assertThat(lotteries.size()).isEqualTo(7);
    }


    @Test
    @DisplayName("생성된 로또들의 일치하는 개수에 대한 건수를 만든다.")
    void match_test() {
        //given
        Lotteries lotteries = new Lotteries(new GenerateCount(3), new MockNumberGenerator());
        WinnerLottery winnerLottery = new WinnerLottery(new LotteryNumbers(List.of(10, 2, 34, 4, 5, 6)), new BonusBall(45));

        //when
        MatchCountPair pair = lotteries.match(winnerLottery);

        assertAll(
                () -> assertThat(pair.countByRank(Rank.FOURTH)).isEqualTo(3),
                () -> assertThat(pair.countByRank(Rank.THIRD)).isEqualTo(0),
                () -> assertThat(pair.countByRank(Rank.SECOND)).isEqualTo(0),
                () -> assertThat(pair.countByRank(Rank.FIRST)).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("보너스볼을 가지고 맞춘 개수가 5개인 경우 SECOND RANK를 리턴한다.")
    void matchWithBonusBall_test() {
        //given
        Lotteries lotteries = new Lotteries(new GenerateCount(1), new MockNumberGenerator());
        WinnerLottery winnerLottery = new WinnerLottery(new LotteryNumbers(List.of(1, 2, 3, 4, 5, 45)), new BonusBall(6));

        //when
        MatchCountPair pair = lotteries.match(winnerLottery);

        //then
        assertThat(pair.countByRank(Rank.SECOND)).isEqualTo(1);
    }
}