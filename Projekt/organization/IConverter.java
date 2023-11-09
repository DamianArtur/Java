import java.time.LocalTime;

public interface IConverter {

    // zamienia czas w strefie czasowej home na czas w strefie czasowej destination
    LocalTime convert(ITimeZone home, ITimeZone away, LocalTime convertedTime, boolean homeDaylightSavingTime, boolean awayDaylightSavingTime);
}
