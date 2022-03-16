package com.xwx;
import java.net.*;
import java.io.*;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private PrintWriter printWriter;
    private BufferedReader bufferedReader;

    public void Start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Сервер запущен");
        socket = serverSocket.accept();
        System.out.println("Клиент подключен");
        printWriter = new PrintWriter(socket.getOutputStream(), true);
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String greeting = bufferedReader.readLine();
        printWriter.println(greeting.replaceAll(" ", "_"));
        printWriter.flush();
    }

    public void Stop() throws IOException {
        bufferedReader.close();
        printWriter.close();
        socket.close();
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.Start(6666);
    }
}