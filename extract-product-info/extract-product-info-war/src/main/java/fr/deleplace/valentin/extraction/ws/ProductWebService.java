package fr.deleplace.valentin.extraction.ws;

import java.io.IOException;

import javax.ws.rs.GET; 
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.deleplace.valentin.extraction.Process;
import fr.deleplace.valentin.extraction.ProductFields;

@Path("extract")
public class ProductWebService {

    Process process = new Process();
    
	@Path("/flat")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String productFlat() throws IOException {
	    String targetURL = "http://www.etronics.com/coby-cve56blu-jammerz-moods-colorful-isolation-stereo-earphones-blue.html";
	    ProductFields results = process.fetchAndExtract(targetURL);
        return results.flatFormat();
    }
	
}
