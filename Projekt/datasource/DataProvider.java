package datasource;

import android.net.sip.SipAudioCall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class DataProvider implements IDataProvider {

    private URL url;
    private InputStream inputStream;
    private InputStreamReader reader;
    private BufferedReader bufferedReader;

    private void init(String address) throws IOException {
        this.url = new URL(address);
        this.inputStream = url.openStream();
        this.reader = new InputStreamReader(inputStream);
        this.bufferedReader = new BufferedReader(reader);
    }

    private String download() throws IOException {

        StringBuilder output = new StringBuilder("");

        String inputLine;
        while ((inputLine = bufferedReader.readLine()) != null) {
            output.append(inputLine);
        }
        bufferedReader.close();

        return output.toString();
    }

    @Override
    public String downloadData(String address) throws IOException {
        this.init(address);
        return this.download();
    }
}
