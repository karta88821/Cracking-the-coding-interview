import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Connection {
    public static void main(String[] args) {

        Thread thread = new Thread();
        thread.start();
        try {
            ServerSocket serverSocket = new ServerSocket(4242);

            while(true) {
                Socket socket = new Socket("127.0.0.1", 1337);

                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String message = "Hello";
                writer.println(message);
                writer.close();
                System.out.println();
            }
            

            // Read
            /*
            InputStreamReader stream = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(stream);
            String message = reader.readLine();
            System.out.println("message: " + message);
            reader.close();
            */

            

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
