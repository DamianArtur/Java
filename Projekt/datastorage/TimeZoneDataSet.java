import organization.ITimeZone;

import java.util.ArrayList;
import java.util.List;

public class TimeZoneDataSet implements IDataSet {

    protected List<ITimeZone> timeZoneList = new ArrayList<>();

    @Override
    public List<ITimeZone> getTimeZonesList() {

        return timeZoneList;
    }

    @Override
    public ITimeZone getTimeZoneByName(String name) {

        for (ITimeZone timeZone : timeZoneList) {
            if (timeZone.getName().equals(name)) {
                return timeZone;
            }
        }

        return null;
    }

    @Override
    public ITimeZone getTimeZoneByIndex(int index) {
        return timeZoneList.get(index);
    }

    @Override
    public String toString() {

        StringBuilder ret = new StringBuilder();

        for (ITimeZone timeZone : timeZoneList) {
            ret.append(timeZone.getName()).append(" | ");
        }

        return ret.toString();
    }
}
