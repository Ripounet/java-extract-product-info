package fr.deleplace.valentin.extraction;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AnalyzeServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    String targetURL = req.getParameter("targetURL");
    ExtractedFields results = extract(targetURL);

    resp.getWriter().print(results);
  }
  
  ExtractedFields extract(String url) throws IOException{
	  ExtractedFields f = new ExtractedFields();
	  Document doc = Jsoup.connect(url).get();

	  f.setTitle( Extractors.TITLE.extract(doc) );
	  f.setPrice( Extractors.PRICE.extract(doc) );
	  f.setBrand( Extractors.BRAND.extract(doc) );
	  f.setManufacturer( Extractors.MANUFACTURER.extract(doc) );
	  f.setNumber( Extractors.NUMBER.extract(doc) );
	  f.setShortDescription( Extractors.SHORT_DESCRIPTION.extract(doc) );
	  f.setCategories( Extractors.CATEGORIES.extract(doc) );
	  
	  return f;
  }
  
  String fetch(String url) throws MalformedURLException, IOException{
	  InputStream in = new URL(url).openStream();

	  try {
	    return IOUtils.toString( in );
	  } finally {
	    IOUtils.closeQuietly(in);
	  }
  }
  
  static class ExtractedFields {
		private String title;
		private String price;
		private String brand;
		private String manufacturer;
		private String number;
		private String shortDescription;
		private List<String> categories;
		
		@Override
		public String toString() {
			return "ExtractedFields [title=" + title + ", price=" + price
					+ ", brand=" + brand + ", manufacturer=" + manufacturer
					+ ", number=" + number + ", shortDescription="
					+ shortDescription + ", categories=" + categories + "]";
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getManufacturer() {
			return manufacturer;
		}

		public void setManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public String getShortDescription() {
			return shortDescription;
		}

		public void setShortDescription(String shortDescription) {
			this.shortDescription = shortDescription;
		}

		public List<String> getCategories() {
			return categories;
		}

		public void setCategories(List<String> categories) {
			this.categories = categories;
		}

		
	}
}
