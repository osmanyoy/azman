package examples.websocket;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/m")
public class MyRestEndpoint {

    @POST
    @Produces("text/plain")
    public String getXml(final String payload) {
        return payload;
    }
}
