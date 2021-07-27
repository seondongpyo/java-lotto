package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

	private final List<Number> numbers;

	private Numbers(List<Number> numbers) {
		this.numbers = numbers;
	}

	public static Numbers from(String[] numberArray) {
		List<Number> numbers = Arrays.stream(numberArray)
								.map(Number::new)
								.collect(Collectors.toList());
		return new Numbers(Collections.unmodifiableList(numbers));
	}

	public int sum() {
		return numbers.stream()
				.mapToInt(Number::getNumber)
				.sum();
	}

}
