import java.io.*;
import java.net.*;
import java.util.*;

public final class WebServer {
    public static void main(String argv[]) throws Exception {
        int port = 6789;
        ServerSocket listenSocket = new ServerSocket(port);
        while (true) {
            Socket connectionSocket = listenSocket.accept();
            HttpRequest request = new HttpRequest(connectionSocket);
            Thread thread = new Thread(request);
            thread.start();
        }
    }
}
