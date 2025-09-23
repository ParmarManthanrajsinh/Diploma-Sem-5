import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Scanner scanner;

    public void start(String serverAddress, int port) {
        try {
            socket = new Socket(serverAddress, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            scanner = new Scanner(System.in);

            Thread receiveThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    System.err.println("Connection closed.");
                }
            });
            receiveThread.start();

            System.out.println("Connected to chat server. Type 'bye' to exit.");

            String input;
            while (true) {
                input = scanner.nextLine();
                out.println(input);
                if ("bye".equalsIgnoreCase(input)) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                if (socket != null) socket.close();
            } catch (IOException e) {
                System.err.println("Error closing socket.");
            }
            if (scanner != null) scanner.close();
        }
    }

    public static void main(String[] args) {
        ChatClient client = new ChatClient();
        client.start("localhost", 8080);
    }
}