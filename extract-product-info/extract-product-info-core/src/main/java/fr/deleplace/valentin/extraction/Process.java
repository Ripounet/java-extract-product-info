package fr.deleplace.valentin.extraction;


import java.io.IOException;
import java.io.InputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Process {

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

}
