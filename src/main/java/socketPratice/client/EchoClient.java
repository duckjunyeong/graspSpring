package socketPratice.client;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EchoClient {

  public static void main(String[] args) {
    String ip = "127.0.0.1";
    int port = 9000;

    try (Socket socket = new Socket(ip, port)) {
      System.out.println("connect server!!");
      System.out.println("server: " +  socket.getInetAddress().getHostAddress());

      PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
      BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

      String message;
      while((message = consoleReader.readLine()) != null){
        printWriter.println(message);

        if (message.equals("exit")) break;
      }


      System.out.println("close connect");
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
