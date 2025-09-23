@echo off
echo Compiling Java files...
javac *.java
if %errorlevel% == 0 (
    echo Compilation successful!
    echo Starting Chat Server...
    echo The server will listen on port 8080
    echo Press Ctrl+C to stop the server
    java ChatServer
) else (
    echo Compilation failed!
)
pause