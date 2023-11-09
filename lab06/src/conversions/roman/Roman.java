import conversions.GenericNumeralSystem;

import java.util.*;

public class Roman implements GenericNumeralSystem {

    List<Integer> arabicNumerals = new ArrayList<>(Arrays.asList(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1));
    List<String> romanNumerals = new ArrayList<>(Arrays.asList("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"));

    @Override
    public String fromArabic(int val) {

        if (val < 1 || val > 3000) {
            throw new UnsupportedOperationException("Zamiana na system rzymski tylko w zakresie 1-3000!");
        }

        int i = 0;
        StringBuilder res = new StringBuilder();

        while ((val > 0) && (i < romanNumerals.size())) {
            if (arabicNumerals.get(i) <= val) {
                res.append(romanNumerals.get(i));
                val -= arabicNumerals.get(i);
            } else {
                i++;
            }
        }

        return res.toString();
    }

    @Override
    public int toArabic(String val) {

        int res = 0;

        int i = 0;
        while ((val.length() > 0) && (i < romanNumerals.size())) {
            if (val.startsWith(romanNumerals.get(i))) {
                res +=  arabicNumerals.get(i);
                val = val.substring(romanNumerals.get(i).length());
            } else {
                i++;
            }
        }

        if (val.length() > 0) {
            throw new UnsupportedOperationException("Format nieprawidłowy!");
        }

        return res;
    }
}
