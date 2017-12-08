package examples.websocket;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class MyWebSocketEndpoint {

    @OnMessage
    public String echoText(final String text) {
        return text;
    }
}
