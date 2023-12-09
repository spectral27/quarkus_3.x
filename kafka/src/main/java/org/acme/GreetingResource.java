package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.UUID;

@Path("/hello")
public class GreetingResource {

    @Inject
    @Channel("quarkusproducer")
    private Emitter<String> emitter;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response send() {
        String uuid = UUID.randomUUID().toString();
        emitter.send(uuid);
        return Response.ok(uuid + " sent").build();
    }

}
