package in.ajsd.example.api;

import in.ajsd.example.proto.ApiEntities.Context;
import in.ajsd.example.proto.ApiEntities.Pulse;

import org.joda.time.DateTime;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/context")
public class ContextApi {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Context getContext() {
    return Context.newBuilder()
        .setBaseUrl("/")
        .build();
  }

  @POST
  @Path("/pulse")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Pulse checkPulse(Pulse pulse) {
    return pulse.toBuilder()
        .setNonce(pulse.getNonce() + 1)
        .setTimestampMs(DateTime.now().getMillis())
        .build();
  }
}
