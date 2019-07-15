

//class product is used to add items in cart

public class Product {
	int productCode;
	String itemName;
	int itemQuantity;
	double itemPrice;
	//get the item code from list of items
public int getproductCode() {
	return productCode;
}
//set the product code in shopping cart
public void setproductCode(int productCode) {
	this.productCode = productCode;
}
//get the item name from list of items
public String getItemName() {
	return itemName;
}
//set the product name in shopping cart
public void setItemName(String itemName) {
	this.itemName = itemName;
}
//get the available quantity from list of items
public int getQuantity() {
	return itemQuantity;
}
//set the product quantity in shopping cart
public void setQuantity(int itemQuantity) {
	this.itemQuantity = itemQuantity;
}
//get the item price from list of items
public double getPrice() {
	return itemPrice;
}
//set the product price in shopping cart
public void setPrice(double itemPrice) {
	this.itemPrice = itemPrice;
}
//constructor
	public Product(int productCode, String itemName, int itemQuantity, double itemPrice) {
		super();
		this.productCode = productCode;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.itemPrice = itemPrice;
	}
}
