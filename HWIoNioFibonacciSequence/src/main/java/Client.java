import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        String localHost = "127.0.0.1";
        int port = 3440;

        try (Scanner scanner = new Scanner(System.in);
             Socket clientSocket = new Socket(localHost, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println("SERVER: " + in.readLine());
            System.out.println("SERVER: " + in.readLine());
            String msg = scanner.nextLine();
            out.println(msg);
            System.out.println("SERVER: " + in.readLine());

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
