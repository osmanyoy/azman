package examples.websocket.v2client;

import java.net.URI;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import examples.websocket.v2client.socket.SocketHandler;

public class ChatClient {

	private static final Logger logger = Logger.getLogger(ChatClient.class.getName());

	public static void main(final String[] args) {
		System.out.println("Click inside the log window");
		System.out.println("Type your message and press Enter");
		System.out.println("Type exit to close the chat");

		try {
			URI uri = new URI("ws://localhost:7001/pm/chat");
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			Session session = container.connectToServer(new SocketHandler(),
			                                            uri);
			RemoteEndpoint.Async remote = session.getAsyncRemote();

			Scanner s = new Scanner(System.in);
			while (s.hasNextLine()) {
				String message = s.nextLine();
				if (message.equals("exit")) {
					break;
				}
				remote.sendText(message);
			}

			session.close(new CloseReason(CloseReason.CloseCodes.NORMAL_CLOSURE,
			                              "Leaving the chat"));

		} catch (Exception ex) {
			ChatClient.logger.log(Level.SEVERE,
			                      "Error Accessing Chat",
			                      ex);
		}
	}

}
