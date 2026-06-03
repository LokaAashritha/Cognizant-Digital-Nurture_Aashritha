import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try {

            ServerSocket serverSocketValue = new ServerSocket(5000);

            System.out.println("Server started. Waiting for client...");

            Socket clientSocketValue = serverSocketValue.accept();

            System.out.println("Client connected!");

            DataInputStream inputStreamValue =
                    new DataInputStream(clientSocketValue.getInputStream());

            DataOutputStream outputStreamValue =
                    new DataOutputStream(clientSocketValue.getOutputStream());

            String receivedMessageValue = "";

            while (!receivedMessageValue.equals("exit")) {

                receivedMessageValue = inputStreamValue.readUTF();

                System.out.println("Client: " + receivedMessageValue);

                outputStreamValue.writeUTF("Server received: " + receivedMessageValue);
                outputStreamValue.flush();
            }

            inputStreamValue.close();
            outputStreamValue.close();
            clientSocketValue.close();
            serverSocketValue.close();

        } catch (Exception e) {

            System.out.println("Server Error: " + e.getMessage());
        }
    }
}