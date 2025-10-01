import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9091);

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

            String clientMsg = "", serverMsg = "";

            while (!serverMsg.equals("exit")) {
                // send client msg
                clientMsg = bReader.readLine();
                output.writeUTF(clientMsg);
                output.flush();

                // get server msg
                serverMsg = input.readUTF();
                System.out.println(serverMsg);
            }

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}