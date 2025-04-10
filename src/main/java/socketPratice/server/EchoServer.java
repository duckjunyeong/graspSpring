package socketPratice.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class EchoServer {

  public static void main(String[] args){
    int port = 9000;
    try(ServerSocket serverSocket = new ServerSocket(port)){
      System.out.println("server socket create!!  " + port);

      try(Socket clinetSocket = serverSocket.accept()){
        System.out.println("connect client!!");
        System.out.println("client: " +  clinetSocket.getInetAddress().getHostAddress());

        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8), true);
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(clinetSocket.getInputStream(), StandardCharsets.UTF_8));

        String message;
        while ((message = consoleReader.readLine()) != null){
          printWriter.println(message);
          if (message.equals("exit")) break;
        }

        System.out.println("close socket");
      }
    }
    catch(IOException e){
      System.err.println(e.getMessage());
    }

  }
}
