import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread {

    private final Socket socket;
    private final Server server;
    private PrintWriter writer;

    public ClientThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        String serverMessage;
        String clientMessage;
        String clientNick = "";

        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            OutputStream outputStream = socket.getOutputStream();
            writer = new PrintWriter(outputStream, true);

            clientNick = reader.readLine();

            server.broadcast("New user " + clientNick + ".");
            System.out.println("New user " + clientNick + ".");

            while (true) {
                clientMessage = reader.readLine();

                if (clientMessage == null || clientMessage.equals("")) {
                    break;
                }

                serverMessage = "[" + clientNick + "]: " + clientMessage;
                server.broadcast(serverMessage);
            }

            server.removeClient(this);

            serverMessage = "User " + clientNick + " left the conversation.";
            server.broadcast(serverMessage);
            System.out.println(serverMessage);

            socket.close();

        } catch (IOException e) {
            server.removeClient(this);
            serverMessage = clientNick + " left the conversation.";
            server.broadcast(serverMessage);
            System.out.println(serverMessage);
        }
    }

    public void send(String message) {
        writer.println(message);
    }
}
