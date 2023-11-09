import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread extends Thread {

    private final Client client;
    private final Socket socket;
    private BufferedReader reader;

    public ReadThread(Socket socket, Client client) {
        this.socket = socket;
        this.client = client;

        try {
            InputStream inputStream = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while(!socket.isClosed()) {
            try {
                String response = reader.readLine();
                client.writeOnPanel(response);

            } catch (IOException e) {
                break;
            }
        }
    }
}
