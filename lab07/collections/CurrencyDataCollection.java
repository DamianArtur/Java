import model.entities.ICurrency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyDataCollection implements IDataCollection {

    protected List<ICurrency> currencyList = new ArrayList<ICurrency>();

    @Override
    public String ToString() {
        StringBuilder ret = new StringBuilder();

        for (ICurrency currency : currencyList) {
            ret.append(currency.getCode()).append("  |  ").append(String.format("%.3f", currency.getRate())).append("  |  ").append(String.format("%5.0f", currency.getFactor())).append("  |  ").append(currency.getName()).append("\n");
        }

        return ret.toString();
    }

    @Override
    public List<ICurrency> getCurrencyList() {
        return currencyList;
    }

    @Override
    public ICurrency getCurrencyByCode(ICurrency currency) {
        for (ICurrency tmpCurrency : currencyList) {
            if(tmpCurrency.getCode().equals(currency.getCode())) {
                return tmpCurrency;
            }
        }
        return null;
    }
}
