import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.util.Scanner;


// SEND
public class received {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {


        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (
                Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
         //  String message = "Hello VENKAT!";
          // System.out.println(" [x] Sent '" + message + "'");
            System.out.println("Enter your username: ");
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

        }



    }
}

