@echo off
echo Compiling Java files...
javac *.java
if %errorlevel% == 0 (
    echo Compilation successful!
    echo Starting Chat Client...
    echo Make sure the server is running before connecting
    java ChatClient
) else (
    echo Compilation failed!
)
pause