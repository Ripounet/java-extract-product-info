package fr.deleplace.valentin.extraction.ws;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IllegalArgumentMapper implements
        ExceptionMapper<IllegalArgumentException> {
    @Override
    public Response toResponse(IllegalArgumentException ex) {
        return Response.status(400).entity(ex.getMessage()).type("text/plain")
                .build();
    }
}
