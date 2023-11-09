import currency.ICurrency;

public class Exchange implements IExchange {

    @Override
    public double exchange(ICurrency src, ICurrency tgt, double amt) {
        return (amt * src.getRate() / src.getFactor()) / (tgt.getRate() / tgt.getFactor());
    }
}
