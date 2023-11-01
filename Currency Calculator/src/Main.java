import vsu.practice.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args){

        System.out.println(Currency.isRuble("3р"));
        System.out.println(Currency.toDollars("12р", BigDecimal.valueOf(2)));
        System.out.println(Currency.toRubles("$52", BigDecimal.valueOf(0.5)));
        System.out.println(Currency.add("$4 + $6"));
        System.out.println(Currency.subtract("38р - 25р"));
    }
}
