import organization.ITimeZone;

import java.util.List;

public interface IDataSet {

    String toString();

    // zwraca referencje do listy wszystkich obiektow TimeZone
    List<ITimeZone> getTimeZonesList();

    // zwraca obiekt typu TimeZone na podstawie nazwy
    ITimeZone getTimeZoneByName(String name);

    ITimeZone getTimeZoneByIndex(int index);
}
