package fr.deleplace.valentin.extraction;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Extractors {
	public static final FieldExtractor<String> TITLE = new FieldExtractor<String>() {
		public String extract(Document doc) {
			 Elements selection = doc.select(".product-name h1");
			  Element title = selection.first();
			  return title.html();
		}
	};

	public static final FieldExtractor<String> PRICE = new FieldExtractor<String>() {
		public String extract(Document doc) {
			Elements selection = doc.select(".product-shop .price");
			Element price = selection.first();
			return price.html();
		}
	};


	public static final FieldExtractor<String> BRAND = new FieldExtractor<String>() {
		public String extract(Document doc) {
			String title = TITLE.extract(doc);
			String brand = title;
			// TODO
			return brand;
		}
	};

	public static final FieldExtractor<String> MANUFACTURER = new FieldExtractor<String>() {
		public String extract(Document doc) {
		  Elements selection = doc.select("#product-attribute-specs-table>tbody>tr>th:contains(Manufacturer)");
		  Element manufacturer = selection.first();
		  return manufacturer.html();
		}
	};

	public static final FieldExtractor<String> NUMBER = new FieldExtractor<String>() {
		public String extract(Document doc) {
		  Elements selection = doc.select("#product-attribute-specs-table>tbody>tr>th:contains(Model number)");
		  Element number = selection.first();
		  return number.html();
		}
	};

	public static final FieldExtractor<String> SHORT_DESCRIPTION = new FieldExtractor<String>() {
		public String extract(Document doc) {
			  Elements selection = doc.select(".short-description .std");
			  Element shortDescription = selection.first();
			  return shortDescription.html();
		}
	};

	public static final FieldExtractor<List<String>> CATEGORIES = new FieldExtractor<List<String>>() {
		public List<String> extract(Document doc) {
			List<String> cats = new ArrayList<>();
			Elements selection = doc.select(".breadcrumbs li");
			//Element price = selection.first();
			return cats;
		}
	};

}
