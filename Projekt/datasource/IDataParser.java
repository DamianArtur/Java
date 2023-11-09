package datasource;

import org.json.JSONException;
import datastorage.IDataSet;

public interface IDataParser {

    // parsuje pobrany plik
    void parse(String input, IDataSet output) throws JSONException;
}
