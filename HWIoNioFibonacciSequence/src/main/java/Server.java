import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static String sequenceFibonacci(int number) {
        int n0 = 1;
        int n1 = 1;
        int n2;
        StringBuilder sequence = new StringBuilder(n0 + " " + n1);
        for (int i = 3; i <= number; i++) {
            n2 = n0 + n1;
            sequence.append(" ").append(n2);
            n0 = n1;
            n1 = n2;
        }
        return sequence.toString();
    }

    public static void main(String[] args) throws IOException {
        int port = 3440;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.println("Connection accepted");
            out.println("Введите количество чисел из последовательности Фибоначчи: ");
            final String number = in.readLine();
            out.println(sequenceFibonacci(Integer.parseInt(number)));
        }
    }
}
