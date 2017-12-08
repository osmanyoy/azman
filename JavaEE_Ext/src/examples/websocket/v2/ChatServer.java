package examples.websocket.v2;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatServer {
	private static final Logger logger = Logger.getLogger(ChatServer.class.getName());
	private static final Set<Session> sessions = new CopyOnWriteArraySet<>();

	@OnOpen
	public void onOpen(final Session session) {
		ChatServer.sessions.add(session);
		session.getAsyncRemote()
		       .sendText("Welcome!");
		this.broadcastMessage("New user has joined the chat");
	}

	@OnClose
	public void onClose(final Session session, final CloseReason reason) {
		ChatServer.sessions.remove(session);
		this.broadcastMessage("User has left the chat");
	}

	@OnError
	public void onError(final Session session, final Throwable ex) {
		ChatServer.logger.log(Level.INFO,
		                      "Web Socket Error",
		                      ex);
		session.getAsyncRemote()
		       .sendText(ex.getMessage());
	}

	@OnMessage
	public void onMessage(final String message) {
		if ((message == null) || (message.length() == 0)) {
			throw new RuntimeException("No actual message received");
		}
		this.broadcastMessage(message);
	}

	private void broadcastMessage(final String message) {
		ChatServer.sessions.stream()
		                   .forEach(s -> s.getAsyncRemote()
		                                  .sendText(message));
	}

}
