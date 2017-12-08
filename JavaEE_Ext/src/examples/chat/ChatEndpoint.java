package examples.chat;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatEndpoint {
    @OnMessage
    public void message(final String message,
                        final Session client) throws IOException,
                                             EncodeException {
        System.out.println("message: " + message);
        for (final Session peer : client.getOpenSessions()) {
            peer.getBasicRemote().sendText(message);
        }
    }
}
