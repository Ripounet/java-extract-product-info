package fr.deleplace.valentin.extraction;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

/**
 * Command line executable for product information extraction.
 * 
 * For given URL, downloads the html page, extract the product fields,
 * and print them on standard output.
 * 
 * @author valentindeleplace
 */
public class Analyze {

	public static void main(String[] args) {
		if(args.length==0 || StringUtils.isBlank(args[0])){
			System.err.println("Please provide the URL of the page to be parsed.");
			System.exit(1);
		}
		String targetURL = args[0];
	    Process process = new Process();
		try {
			ProductFields results = process.fetchAndExtract(targetURL);
			System.out.print(results.flatFormat());
			process.emitWarnings(results, System.err);
		} catch (IOException e) {
			System.err.println("Networking problem :" + e.getMessage());
			System.exit(1);
		}
	}

}
