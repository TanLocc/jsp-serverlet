package hello;

public class Dog {
 private String color; 
 private String name;
 private String breed;
 private String behavior;
public Dog(String color, String name, String breed, String behavior) {
	super();
	this.color = color;
	this.name = name;
	this.breed = breed;
	this.behavior = behavior;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBreed() {
	return breed;
}
public void setBreed(String breed) {
	this.breed = breed;
}
public String getBehavior() {
	return behavior;
}
public void setBehavior(String behavior) {
	this.behavior = behavior;
}
 
}
