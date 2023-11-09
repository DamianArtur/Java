import java.io.*;
import java.net.Socket;

public class WriteThread extends Thread {

    private final Client client;
    private PrintWriter writer;

    public WriteThread(Socket socket, Client client) {
        this.client = client;

        try {
            OutputStream outputStream = socket.getOutputStream();
            writer = new PrintWriter(outputStream, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        writer.println(client.getClientNick());
    }

    public void sendMessage(String message) {
        writer.println(message);
    }
}