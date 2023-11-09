package datasource;

import datastorage.IDataSet;
import org.json.*;
import organization.ITimeZone;
import organization.TimeZone;

public class JSONDataParser implements IDataParser {

    @Override
    public void parse(String input, IDataSet output) throws JSONException {
        JSONArray array = new JSONArray(input);

        for (int i = 0; i < array.length(); i++) {
            ITimeZone timeZone = new TimeZone();
            JSONObject res = array.getJSONObject(i);

            timeZone.setOffset(Integer.parseInt(res.getString("rawOffsetInMinutes")));
            String[] name = res.getString("name").split("/");
            timeZone.setName(name[1]);
            timeZone.setCountryName(res.getString("countryName"));
            timeZone.setContinentName(res.getString("continentName"));
            output.getTimeZonesList().add(timeZone);
        }
    }
}
