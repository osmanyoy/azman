package examples.chat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ClientEndpoint
public class ChatClientEndpoint1 {
    public static String         TEXT = "Client1 joins";
    public static CountDownLatch latch;
    public static String         response;

    @OnOpen
    public void onOpen(final Session session) {
        try {
            session.getBasicRemote().sendText(ChatClientEndpoint1.TEXT);
        } catch (final IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @OnMessage
    public void processMessage(final String message) {
        ChatClientEndpoint1.response = message;
        ChatClientEndpoint1.latch.countDown();
    }
}
