package step02;

import static step02.LottoConfig.*;

public class Validation {

    private Validation() {
    }

    public static void overMaxNumber(int number){
        if (number > NUMBER_RANGE_END) {
            throw new IllegalArgumentException(ERROR_OVER_MAX_NUMBER);
        }
    }

    public static void numberCount(int size){
        if (size > LOTTO_NUMBER_MAX_COUNT || size <= ZERO) {
            throw new IllegalArgumentException(ERROR_OVER_MAX_NUMBER_COUNT);
        }
    }

    public static void checkMinPrice(int price){
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_MIN_PRICE);
        }
    }

}
