import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Server {

    private final int port;
    private final Set<ClientThread> clientThreads = new HashSet<>();

    public Server(int port) {
        this.port = port;
    }

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(port, 0, InetAddress.getByName(null));
            System.out.println("Server is running...");

            while (true) {
                Socket socket = serverSocket.accept();
                ClientThread newClient = new ClientThread(socket, this);
                clientThreads.add(newClient);
                newClient.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcast(String message) {
        for (ClientThread clientThread : clientThreads) {
            clientThread.send(message);
        }
    }

    public void removeClient(ClientThread client) {
        clientThreads.remove(client);
    }

    public static void main(String[] args) {
        Server server = new Server(9999);
        server.run();
    }
}
