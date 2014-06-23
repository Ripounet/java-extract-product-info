package fr.deleplace.valentin.extraction;


import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;

/**
 * POJO bean to hold product values.
 * 
 * @author valentindeleplace
 */
@XmlRootElement
public class ProductFields {

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

	public String flatFormat() {
		StringBuilder sb = new StringBuilder();
		sb.append("Title: ");
		sb.append(StringUtils.defaultString(title));
		sb.append("\n");
		sb.append("Price: ");
		sb.append(StringUtils.defaultString(price));
		sb.append("\n");
		sb.append("Brand: ");
		sb.append(StringUtils.defaultString(brand));
		sb.append("\n");
		sb.append("Manufacturer: ");
		sb.append(StringUtils.defaultString(manufacturer));
		sb.append("\n");
		sb.append("Number: ");
		sb.append(StringUtils.defaultString(number));
		sb.append("\n");
		sb.append("Short description: ");
		sb.append(StringUtils.defaultString(shortDescription));
		sb.append("\n");
		sb.append("Categories: ");
		sb.append(StringUtils.join(categories,", "));
		sb.append("\n");
		return sb.toString();
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
