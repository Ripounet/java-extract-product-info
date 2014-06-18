package fr.deleplace.valentin.extraction;

import java.util.List;

/**
 * POJO bean to hold product values.
 * 
 * @author valentindeleplace
 */
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
