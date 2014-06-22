package fr.deleplace.valentin.extraction.ws;

import java.io.IOException;

import javax.ws.rs.GET; 
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;

import fr.deleplace.valentin.extraction.Process;
import fr.deleplace.valentin.extraction.ProductFields;

@Path("extract")
public class ProductWebService {

    Process process = new Process();
    
	@Path("/flat")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String productFlat(@QueryParam("targetURL") String targetURL) throws IOException {
		if(StringUtils.isBlank(targetURL))
			throw new IllegalArgumentException("Please provide the URL of the page to be parsed.");
	    ProductFields results = process.fetchAndExtract(targetURL);
        return results.flatFormat();
    }
	
	@Path("/json")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ProductFields productJson(@QueryParam("targetURL") String targetURL) throws IOException {
		if(StringUtils.isBlank(targetURL))
			throw new IllegalArgumentException("Please provide the URL of the page to be parsed.");
	    ProductFields results = process.fetchAndExtract(targetURL);
        return results;
	}
}
