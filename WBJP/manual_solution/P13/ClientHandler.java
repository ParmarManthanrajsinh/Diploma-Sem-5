import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private ChatServer server;
    private BufferedReader in;
    private PrintWriter out;
    private String clientName;

    public ClientHandler(Socket socket, ChatServer server) {
        this.clientSocket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.println("Enter your name:");
            clientName = in.readLine();
            System.out.println(clientName + " joined the chat.");
            server.broadcastMessage(clientName + " joined the chat.", this);

            String message;
            while ((message = in.readLine()) != null) {
                if (message.equals("bye")) {
                    break;
                }
                System.out.println(clientName + ": " + message);
                server.broadcastMessage(clientName + ": " + message, this);
            }

            server.broadcastMessage(clientName + " left the chat.", this);
            System.out.println(clientName + " left the chat.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
                server.removeClient(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}