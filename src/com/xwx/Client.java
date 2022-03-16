package com.xwx;
import java.net.*;
import java.io.*;

public class Client {
    private Socket socket;
    private PrintWriter printWriter;
    private BufferedReader bufferedReader;

    public void Conn(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        printWriter = new PrintWriter(socket.getOutputStream(), true);
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public String Msg(String msg) throws IOException {
        printWriter.println(msg);
        printWriter.flush();
        String resp = "";
        try {
            resp = bufferedReader.readLine();
        }
        catch (IOException e) {
            StopConn();
        }
        return resp;
    }

    public void StopConn() throws IOException {
        bufferedReader.close();
        printWriter.close();
        socket.close();
    }
}