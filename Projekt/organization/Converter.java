import java.time.LocalTime;

public class Converter implements IConverter {

    @Override
    public LocalTime convert(ITimeZone home, ITimeZone away, LocalTime convertedTime, boolean homeDaylightSavingTime, boolean awayDaylightSavingTime) {

        int homeOffset = home.getOffset();
        int awayOffset = away.getOffset();

        if (homeDaylightSavingTime) {
            homeOffset += 60;
        }

        if (awayDaylightSavingTime) {
            awayOffset += 60;
        }

        return convertedTime.plusMinutes(awayOffset - homeOffset);
    }
}
