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
            
            // Handle incoming messages in a separate thread
            new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            
            // Send messages
            System.out.println("Connected to chat server. Type 'bye' to exit.");
            String input;
            while (!(input = scanner.nextLine()).equals("bye")) {
                out.println(input);
            }
            
            // Close connections
            out.println("bye");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                scanner.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        ChatClient client = new ChatClient();
        client.start("localhost", 8080);
    }
}