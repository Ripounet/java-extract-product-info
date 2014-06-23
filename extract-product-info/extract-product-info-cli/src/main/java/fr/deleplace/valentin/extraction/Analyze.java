package fr.deleplace.valentin.extraction;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

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
		} catch (IOException e) {
			System.err.println("Networking problem :" + e.getMessage());
		}
	}

}
