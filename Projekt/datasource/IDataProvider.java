package datasource;

import java.io.IOException;

public interface IDataProvider {

    // pobiera dane z pliku
    String downloadData(String address) throws IOException;
}
