import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private static JFrame mainFrame;
    private JPanel mainPanel;
    private JTextField messageTextField;
    private JButton sendButton;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    private final int port;
    private final String hostname;
    private final String clientNick;
    private Socket socket;
    private WriteThread writeThread;

    public Client(String hostname, int port, String clientNick) {

        this.hostname = hostname;
        this.port = port;
        this.clientNick = clientNick;

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    socket.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                System.exit(0);
            }
        });


        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        sendButton.addComponentListener(new ComponentAdapter() {
        });
        sendButton.addActionListener(e -> writeThread.sendMessage(messageTextField.getText()));
    }

    public void run() {
        try {
            socket = new Socket(hostname, port);
            writeOnPanel("Connected to server...");
            ReadThread readThread = new ReadThread(socket, this);
            writeThread = new WriteThread(socket, this);
            readThread.start();
            writeThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getClientNick() {
        return this.clientNick;
    }

    public void writeOnPanel(String message) {
        textArea.append(message + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        mainFrame = new JFrame("Chat");
        String clientNick = null;
        while (clientNick == null || clientNick.length() == 0) {
            clientNick = JOptionPane.showInputDialog(mainFrame, "Set your nickname: ", "Nickname", JOptionPane.PLAIN_MESSAGE);
        }

        Client client = new Client("localhost", 9999, clientNick);
        client.run();

        mainFrame.setContentPane(client.mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setSize(300, 400);
        mainFrame.setVisible(true);
    }
}
