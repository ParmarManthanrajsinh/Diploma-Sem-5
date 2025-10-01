import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9091);
            Socket socket = serverSocket.accept();

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

            String clientMsg = "", serverMsg = "";

            while (!serverMsg.equals("exit")) {
                // sent server msg
                serverMsg = bReader.readLine();
                output.writeUTF(serverMsg);
                output.flush();

                // get client msg
                clientMsg = input.readUTF();
                System.out.println(clientMsg);
            }

            serverSocket.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
