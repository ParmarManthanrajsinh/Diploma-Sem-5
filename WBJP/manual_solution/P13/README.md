# Simple Java Chat Application

This is a simple chat application implemented using Java socket programming.

## Files

1. `ChatServer.java` - The server that handles multiple client connections
2. `ClientHandler.java` - Manages individual client connections
3. `ChatClient.java` - The client application

## How to Compile and Run

### Using Batch Files (Windows)

For easier execution on Windows, batch files have been provided:

1. `compile.bat` - Compiles all Java files
2. `run_server.bat` - Runs the chat server
3. `run_client.bat` - Runs a chat client
4. `compile_and_run_server.bat` - Compiles and runs the chat server
5. `compile_and_run_client.bat` - Compiles and runs a chat client

Simply double-click on the desired batch file to execute it.

### Manual Compilation and Execution

#### Compile the Java files:
```bash
javac *.java
```

#### Run the Server:
```bash
java ChatServer
```

#### Run Clients:
In separate terminals/command prompts, run:
```bash
java ChatClient
```

You can run multiple clients to test the chat functionality.

## How It Works

1. The server listens on port 8080 for incoming client connections
2. Each client connects to the server and provides a name
3. Messages sent by any client are broadcast to all other connected clients
4. Type "bye" to disconnect from the chat

## Features

- Multi-client support
- Real-time messaging
- Simple and easy to understand implementation