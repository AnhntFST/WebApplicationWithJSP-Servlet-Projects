package ams4.Package.model;

public class Products {
	private Integer id;
	private String name;
	private String des;
	private String type;
	private Double price;
	private String brand;
	private String img_source;
	
	public Products(String name, String des, String type, Double price, String brand, String img_source) {
		super();
		this.name = name;
		this.des = des;
		this.type = type;
		this.price = price;
		this.brand = brand;
		this.img_source = img_source;
	}

	public Products(Integer id, String name, String des, String type, Double price, String brand, String img_source) {
		super();
		this.id = id;
		this.name = name;
		this.des = des;
		this.type = type;
		this.price = price;
		this.brand = brand;
		this.img_source = img_source;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getImg_source() {
		return img_source;
	}

	public void setImg_source(String img_source) {
		this.img_source = img_source;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", des=" + des + ", type=" + type + ", price=" + price
				+ ", brand=" + brand + ", img_source=" + img_source + "]";
	}
	
	
	
}
