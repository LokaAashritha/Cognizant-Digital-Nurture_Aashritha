import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        try {

            Socket socketValue = new Socket("localhost", 5000);

            DataInputStream inputStreamValue =
                    new DataInputStream(socketValue.getInputStream());

            DataOutputStream outputStreamValue =
                    new DataOutputStream(socketValue.getOutputStream());

            Scanner userInputReader = new Scanner(System.in);

            String messageValue = "";

            while (!messageValue.equals("exit")) {

                System.out.print("You: ");
                messageValue = userInputReader.nextLine();

                outputStreamValue.writeUTF(messageValue);
                outputStreamValue.flush();

                System.out.println(inputStreamValue.readUTF());
            }

            userInputReader.close();
            inputStreamValue.close();
            outputStreamValue.close();
            socketValue.close();

        } catch (Exception e) {

            System.out.println("Client Error: " + e.getMessage());
        }
    }
}