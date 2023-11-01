package vsu.practice;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Currency {
    private static final String ruble = "\\d+р";
    private static final String dollar = "\\$+\\d";


    public static boolean isRuble(String input){
        Pattern pattern = Pattern.compile(ruble);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
    public static String toRubles(String input, BigDecimal exchangeRate){
        input = input.replace("$","");
        BigDecimal inRubles = new BigDecimal(input);
        inRubles = inRubles.multiply(exchangeRate);
        return String.valueOf(inRubles) + "р";
    }

    public static boolean isDollar(String input){
        Pattern pattern = Pattern.compile(dollar);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public static String toDollars(String input, BigDecimal exchangeRate){
        input = input.replace("р","");
        BigDecimal inDollars = new BigDecimal(input);
        inDollars = inDollars.multiply(exchangeRate);
        return "$" + String.valueOf(inDollars);
    }

    public static String add(String input){
        String[] terms = input.split("\\+");
        if (Currency.isDollar(terms[0]) && Currency.isDollar(terms[1])){
            terms[0] = terms[0].replace("$","").trim();
            terms[1] = terms[1].replace("$","").trim();

           BigDecimal sum = new BigDecimal(terms[0]).add(new BigDecimal(terms[1]));
           return "$" + String.valueOf(sum);
        } else if (Currency.isRuble(terms[0]) && Currency.isRuble(terms[1])) {
            terms[0] = terms[0].replace("р","").trim();
            terms[1] = terms[1].replace("р","").trim();

            BigDecimal sum = new BigDecimal(terms[0]).add(new BigDecimal(terms[1]));
            return String.valueOf(sum) + "р";
        }
        return null;
    }

    public static String subtract(String input){
        String[] terms = input.split("-");
        if (Currency.isDollar(terms[0]) && Currency.isDollar(terms[1])){
            terms[0] = terms[0].replace("$","").trim();
            terms[1] = terms[1].replace("$","").trim();

            BigDecimal diff = new BigDecimal(terms[0]).subtract(new BigDecimal(terms[1]));
            return "$" + String.valueOf(diff);
        } else if (Currency.isRuble(terms[0]) && Currency.isRuble(terms[1])) {
            terms[0] = terms[0].replace("р","").trim();
            terms[1] = terms[1].replace("р","").trim();

            BigDecimal diff = new BigDecimal(terms[0]).subtract(new BigDecimal(terms[1]));
            return String.valueOf(diff) + "р";
        }
        return null;
    }
}
