import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SquareClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {
            
            System.out.println("Connected to server");
            
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            
            // Send numbers to server
            out.println(num1 + " " + num2);
            
            // Receive squares from server
            String response = in.readLine();
            System.out.println("Server response: " + response);
            
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}