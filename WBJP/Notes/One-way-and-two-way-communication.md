## 🌐 What Is Socket Programming?

**Socket programming** in Java enables two computers (or programs) to communicate over a network (like the Internet or a LAN).

* A **socket** is an endpoint for sending or receiving data across a network.
* Typically, one side acts as a **Server** and the other as a **Client**.

📘 Java provides socket classes in the package:

```java
java.net
```

---

## 🧱 Basic Concepts

| Concept                        | Description                                                |
| ------------------------------ | ---------------------------------------------------------- |
| **ServerSocket**               | Used by the server to listen for incoming client requests. |
| **Socket**                     | Used by both client and server to send/receive data.       |
| **InputStream / OutputStream** | Used to read from and write to a socket connection.        |
| **Port**                       | A numeric identifier for a specific process (e.g., 8080).  |
| **IP Address**                 | Identifies the machine on the network.                     |

---

## 🧩 Typical Flow

### 🖥️ **Server Side**

1. Create a `ServerSocket` object with a specific port number.
2. Wait for a client using `accept()`.
3. Get the client’s `Socket` object.
4. Use `InputStream` and `OutputStream` to communicate.
5. Close the connection.

### 💻 **Client Side**

1. Create a `Socket` object and connect to the server’s IP + port.
2. Get `InputStream` and `OutputStream`.
3. Send or receive data.
4. Close the connection.

---

## 💻 Example 1: Simple One-to-One Communication

### 🖥️ Server Program (`Server.java`)

```java
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started. Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        // Create input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Communicate
        String message = in.readLine();
        System.out.println("Client says: " + message);
        out.println("Hello Client, message received!");

        // Close connections
        in.close();
        out.close();
        socket.close();
        serverSocket.close();
    }
}
```

---

### 💻 Client Program (`Client.java`)

```java
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);

        // Create input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println("Hello Server!");
        System.out.println("Server says: " + in.readLine());

        // Close connections
        in.close();
        out.close();
        socket.close();
    }
}
```

---

### 🧾 Output

**Server console:**

```
Server started. Waiting for client...
Client connected!
Client says: Hello Server!
```

**Client console:**

```
Server says: Hello Client, message received!
```

---

## ⚙️ How It Works

| Step                                     | Description                           |
| ---------------------------------------- | ------------------------------------- |
| `new ServerSocket(5000)`                 | Server starts listening on port 5000. |
| `accept()`                               | Waits until a client connects.        |
| `new Socket("localhost", 5000)`          | Client connects to the server.        |
| `getInputStream()` / `getOutputStream()` | Data channels are created.            |
| `println()` / `readLine()`               | Text communication happens.           |

---

## 🧮 Example 2: Two-Way Chat (Interactive)

### Server Side

```java
import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Chat server started...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String message;
        while (true) {
            message = in.readLine();
            if (message.equalsIgnoreCase("bye")) break;
            System.out.println("Client: " + message);

            System.out.print("You: ");
            String reply = keyboard.readLine();
            out.println(reply);
        }

        socket.close();
        serverSocket.close();
    }
}
```

### Client Side

```java
import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6000);
        System.out.println("Connected to chat server!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String message;
        while (true) {
            System.out.print("You: ");
            message = keyboard.readLine();
            out.println(message);
            if (message.equalsIgnoreCase("bye")) break;
            System.out.println("Server: " + in.readLine());
        }

        socket.close();
    }
}
```

---

## 📚 Important Socket Classes

| Class                            | Description                                  |
| -------------------------------- | -------------------------------------------- |
| `Socket`                         | Represents the client’s connection endpoint. |
| `ServerSocket`                   | Waits for client connections.                |
| `InetAddress`                    | Represents an IP address.                    |
| `InputStream` / `OutputStream`   | For reading/writing raw data.                |
| `BufferedReader` / `PrintWriter` | For text communication.                      |

---

## ⚠️ Common Issues

| Problem                     | Cause                            | Fix                                               |
| --------------------------- | -------------------------------- | ------------------------------------------------- |
| `java.net.BindException`    | Port already in use              | Choose a different port                           |
| `java.net.ConnectException` | Server not running or wrong port | Start the server first                            |
| `SocketTimeoutException`    | Timeout during connection        | Use `setSoTimeout()` to handle                    |
| Garbled text                | Mixed encodings                  | Ensure both use same encoding (UTF-8 recommended) |

---

## 🏁 Summary

| Concept       | Client                                  | Server                                  |
| ------------- | --------------------------------------- | --------------------------------------- |
| Start point   | Connects to IP + port                   | Listens on a port                       |
| Object used   | `Socket`                                | `ServerSocket`                          |
| Communication | Streams (`InputStream`, `OutputStream`) | Streams (`InputStream`, `OutputStream`) |
| End           | Close socket                            | Close socket + server socket            |

---
