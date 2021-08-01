package lotto.domain;

import java.util.Objects;

import lotto.exception.InsufficientMoneyException;

public class Money {

	private static final int PRICE_PER_TICKET = 1000;

	private int amount;

	public Money(int amount) {
		validateMoneyAmount(amount);
		this.amount = amount;
	}

	public int availableLottoTicketsCount() {
		return amount / PRICE_PER_TICKET;
	}

	private void validateMoneyAmount(int amount) {
		if (isInsufficientForBuyingLottoTicket(amount)) {
			throw new InsufficientMoneyException(amount);
		}
	}

	private boolean isInsufficientForBuyingLottoTicket(int amount) {
		return amount < PRICE_PER_TICKET;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Money money = (Money)o;
		return amount == money.amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}
}
