package org.acme;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Path("/dists")
public class DistributionResource {

    @GET
    public Uni<List<Distribution>> selectAll() {
        return Distribution.listAll();
    }

    @GET
    @Path("/{id}")
    public Uni<Distribution> select(String id) {
        return Distribution.findById(Integer.parseInt(id));
    }

    @POST
    public Uni<RestResponse<Distribution>> insert(Distribution myEntity) {
        return Panache.withTransaction(myEntity::persist)
                .replaceWith(RestResponse.ok(myEntity));
    }

}
