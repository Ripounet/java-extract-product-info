package fr.deleplace.valentin.extraction;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Extractors {
	public static final FieldExtractor<String> TITLE = new FieldExtractor<String>() {
		public String extract(Document doc) {
			 Elements selection = doc.select(".product-name h1");
			  if(selection.isEmpty())
				  return null;
			 Element title = selection.first();
			 return flatten(title.text());
		}
	};

	public static final FieldExtractor<String> PRICE = new FieldExtractor<String>() {
		public String extract(Document doc) {
			Elements selection = doc.select(".product-shop .price");
			  if(selection.isEmpty())
				  return null;
			Element price = selection.first();
			return flatten(price.text());
		}
	};

	/** Although there is no distinct field "brand" in the page,
	 * we can observe that the title always begins with what looks
	 * like the Brand.
	 */
	public static final FieldExtractor<String> BRAND = new FieldExtractor<String>() {
		public String extract(Document doc) {
			String brand = null;
			String title = TITLE.extract(doc);
			if(!StringUtils.isBlank(title))
				brand = title.trim().split(" ")[0];
			return brand;
		}
	};

	public static final FieldExtractor<String> MANUFACTURER = new FieldExtractor<String>() {
		public String extract(Document doc) {
		  Elements selection = doc.select("#product-attribute-specs-table>tbody>tr>th:contains(Manufacturer)");
		  if(selection.isEmpty())
			  return null;
		  Element manufacturerTh = selection.first();
		  Element manufacturer = manufacturerTh.nextElementSibling();
		  return flatten(manufacturer.text());
		}
	};

	public static final FieldExtractor<String> NUMBER = new FieldExtractor<String>() {
		public String extract(Document doc) {
		  Elements selection = doc.select("#product-attribute-specs-table>tbody>tr>th:contains(Model number)");
		  if(selection.isEmpty())
			  return null;
		  Element numberTh = selection.first();
		  Element number = numberTh.nextElementSibling();
		  return flatten(number.text());
		}
	};

	public static final FieldExtractor<String> SHORT_DESCRIPTION = new FieldExtractor<String>() {
		public String extract(Document doc) {
			  Elements selection = doc.select(".short-description .std");
			  if(selection.isEmpty())
				  return null;
			  Element shortDescription = selection.first();
			  return flatten(shortDescription.text());
		}
	};

	public static final FieldExtractor<List<String>> CATEGORIES = new FieldExtractor<List<String>>() {
		public List<String> extract(Document doc) {
			List<String> cats = new ArrayList<>();
			Elements selection = doc.select(".breadcrumbs li");
			for(Element item:selection)
				if(item.hasAttr("class") && item.attr("class").contains("category")){
					Elements links = item.select("a");
					if(!links.isEmpty()){
						Element a = links.first();
						String cat = flatten(a.text());
						cats.add(cat);
					}
				}
			return cats;
		}
	};
	
	static String flatten(String s){
		if(s==null)
			return null;
		return s.replaceAll("\n", " ").trim();
	}

}
