import java.io.*;
import java.net.*;

public class SquareServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server started on port 8080");
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;
    
    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }
    
    @Override
    public void run() {
        // Use try-with-resources to ensure streams are properly closed
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            
            String line = in.readLine();
            
            if (line == null) {
                return;
            }
            
            String[] numbers = line.split(" ");
            
            if (numbers.length >= 2) {
                try {
                    double num1 = Double.parseDouble(numbers[0]);
                    double num2 = Double.parseDouble(numbers[1]);
                    
                    double result = Math.pow(num1, num2);

                    out.println(result);
                } catch (NumberFormatException e) {
                    out.println("Invalid numbers received");
                }
            } else {
                out.println("Invalid input format");
            }
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        }
    }
}