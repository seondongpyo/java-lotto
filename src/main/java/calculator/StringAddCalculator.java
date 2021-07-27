package calculator;

public class StringAddCalculator {

	private static final int NULL_OR_EMPTY_RESULT = 0;

	private StringAddCalculator() {
	}

	public static void main(String[] args) {
		int result = splitAndSum(",1");
		System.out.println("result = " + result);
	}

	public static int splitAndSum(String inputText) {
		if (isBlank(inputText)) {
			return NULL_OR_EMPTY_RESULT;
		}

		String[] numberArray = Splitter.split(inputText);
		Numbers numbers = Numbers.from(numberArray);
		return numbers.sum();
	}

	private static boolean isBlank(String inputText) {
		return inputText == null || inputText.isEmpty();
	}

}
