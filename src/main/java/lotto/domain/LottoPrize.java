package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {

	NO_NUMBER(0, 0),
	ONE_NUMBER(1, 0),
	TWO_NUMBERS(2, 0),
	THREE_NUMBERS(3, 5_000),
	FOUR_NUMBERS(4, 50_000),
	FIVE_NUMBERS(5, 1_500_000),
	SIX_NUMBERS(6, 2_000_000_000);

	private final long matchCount;
	private final int prizeMoney;

	LottoPrize(long matchCount, int prizeMoney) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
	}

	static LottoPrize fromMatchCount(long matchCount) {
		return Arrays.stream(values())
				.filter(value -> value.matchCount == matchCount)
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

	public int prizeMoney() {
		return prizeMoney;
	}


}
