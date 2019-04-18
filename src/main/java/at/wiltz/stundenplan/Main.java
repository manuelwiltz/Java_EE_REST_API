package at.wiltz.stundenplan;

import java.io.IOException;
import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Manuel
 */
public class Main {

    public static final String URL = "http://localhost:8080/server/api/";

    public static void main(String[] args) throws IOException {
        
        final ResourceConfig rc = new ResourceConfig().packages("at.wiltz.stundenplan");
        rc.register(MultiPartFeature.class);
        rc.register(new CORSFilter());
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(URL), rc);

        StaticHttpHandler handler2 = new StaticHttpHandler("");
        server.getServerConfiguration().addHttpHandler(handler2, "/");

        System.out.println(String.format("Server startet at %s.\nHit enter to stop ...", URL));
        System.in.read();
        server.shutdown();
    }

}
