import conversions.GenericNumeralSystem;

public class Urnfield implements GenericNumeralSystem {
    @Override
    public String fromArabic(int val) {

        if (val < 1 || val > 29) {
            throw new UnsupportedOperationException("Zamiana na system prastary tylko w zakresie 1-29!");
        }

        StringBuilder res = new StringBuilder();

        int p = val / 5;
        int q = val % 5;

        int i = 0;
        while (i < q) {
            res.append("/");
            i++;
        }
        i = 0;
        while (i < p) {
            res.append("\\");
            i++;
        }

        return res.toString();
    }

    @Override
    public int toArabic(String val) {

        int numberOfOneChar = 0;
        boolean fiveChar = false;
        for(int i = 0; i < val.length(); i++) {
            if(val.charAt(i) == '/') {
                numberOfOneChar++;
                if (numberOfOneChar > 4 || fiveChar) {
                    throw new UnsupportedOperationException("Format nieprwidłowy!");
                }
            } else if(val.charAt(i) == '\\') {
                fiveChar = true;
            } else {
                throw new UnsupportedOperationException("Nierozpoznany znak!");
            }
        }

        int res = 0;

        for (int i = 0; i < val.length(); i++) {
            if(val.charAt(i) == '/') {
                res += 1;
            } else if (val.charAt(i) == '\\') {
                res += 5;
            }
        }

        return res;
    }
}
