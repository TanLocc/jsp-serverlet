package beans;

import java.io.InputStream;

public class Product {
 private int id;
 private InputStream image;
 private String name;
 private String cate;
 private float price;
 private String des;
 private String detail;
 
public Product(int id, InputStream image, String name,String cate, float price, String des, String detail) {
	super();
	this.id = id;
	this.image = image;
	this.name = name;
	this.cate =cate;
	this.price = price;
	this.des = des;
	this.detail = detail;
}

public Product() {
	// TODO Auto-generated constructor stub
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public InputStream getImage() {
	return image;
}
public void setImage(InputStream image) {
	this.image = image;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getDes() {
	return des;
}
public void setDes(String des) {
	this.des = des;
}
public String getDetail() {
	return detail;
}
public void setDetail(String detail) {
	this.detail = detail;
}

public String getCate() {
	return cate;
}

public void setCate(String cate) {
	this.cate = cate;
}
 
}
