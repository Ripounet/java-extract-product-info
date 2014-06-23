package fr.deleplace.valentin.extraction;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * This extraction process instantiates a JSoup parses which yields a Document,
 * and uses Extractors to produce a ProductFields result bean.
 * 
 * @author valentindeleplace
 */
public class Process {

	public static final int ALERT_THRESHOLD = 10;
	
	public ProductFields fetchAndExtract(String url) throws IOException {
		Document doc = Jsoup.connect(url).get();
		return extract(doc);
	}

	public ProductFields extractFromStream(InputStream in, String charset, String baseUrl) throws IOException {
		Document doc = Jsoup.parse(in, charset, baseUrl);
		return extract(doc);
	}

	public ProductFields extract(Document doc) throws IOException {
		ProductFields f = new ProductFields();

		f.setTitle(Extractors.TITLE.extract(doc));
		f.setPrice(Extractors.PRICE.extract(doc));
		f.setBrand(Extractors.BRAND.extract(doc));
		f.setManufacturer(Extractors.MANUFACTURER.extract(doc));
		f.setNumber(Extractors.NUMBER.extract(doc));
		f.setShortDescription(Extractors.SHORT_DESCRIPTION.extract(doc));
		f.setCategories(Extractors.CATEGORIES.extract(doc));

		return f;
	}

	/**
	 * When extraction result is abnormally poor, print some warnings 
	 * and/or send an alert email.
	 */
	public void emitWarnings(ProductFields f, PrintStream alert){
		int anomalyScore = 0;
		List<String> problemFieldNames = new ArrayList<>();
		if(StringUtils.isBlank(f.getTitle())){
			anomalyScore += 10;
			problemFieldNames.add("Title");
		}
		if(StringUtils.isBlank(f.getPrice())){
			anomalyScore += 10;
			problemFieldNames.add("Price");
		}
		if(StringUtils.isBlank(f.getBrand())){
			anomalyScore += 3;
			problemFieldNames.add("Brand");
		}
		if(StringUtils.isBlank(f.getManufacturer())){
			anomalyScore += 3;
			problemFieldNames.add("Manufacturer");
		}
		if(StringUtils.isBlank(f.getNumber())){
			anomalyScore += 3;
			problemFieldNames.add("Part number");
		}
		if(StringUtils.isBlank(f.getShortDescription())){
			anomalyScore += 4;
			problemFieldNames.add("Short description");
		}
		if(f.getCategories().isEmpty()){
			anomalyScore += 10;
			problemFieldNames.add("Categories");
		}
		
		if(anomalyScore >= ALERT_THRESHOLD){
			alert.println("\nCould not extract fields : " + problemFieldNames);
			alert.println("Cause could be: wrong page URL, or site layout has changed.");
		}
	}
	
}
