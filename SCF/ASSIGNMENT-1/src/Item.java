import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//class Item is for list of items available.
public class Item {
private static Scanner sc;
public static List<Product> listOfItems = new ArrayList<Product>();
public static ShoppingCart cart = new ShoppingCart();
public static void main (String[] args){
//Menu for operations to be performed on cart.
System.out.println("Choose from the given options:");
int optionSelected = 0;
boolean quit=false;
do {
	System.out.println("1.)Add item to cart");
	System.out.println("2.)Update the item quantity");
	System.out.println("3.)Show cart items");
	System.out.println("4.)Generate Bill");
	System.out.println("5.)EXIT");
	sc = new Scanner(System.in);
	try {
		optionSelected = sc.nextInt();
	} catch (Exception e) {
		System.out.println("Enter a valid number");
	}

	switch (optionSelected){
	case 1:
		cart.addItem( fetchProductDetails());
		break;
	case 2:
		cart.updateCart();
		break;
	case 3:
		cart.showCart();
		break;
	case 4:
		cart.generateBill();
		break;
	case 5:
		quit=true;
		break;
	}
}
while(!quit);
}

//Initialize the list of items
public static void initializeListItems(){
//List of items available 
listOfItems.add(new Product(1,"Apple ",50,100.00));
listOfItems.add(new Product(2,"Mango ",6,120.00));
listOfItems.add(new Product(3,"Banana",11, 45.00));
listOfItems.add(new Product(4,"Papaya",25, 30.00));
listOfItems.add(new Product(5,"Guava ",22,150.00));
}

//fetch details of items present in list
public static Product fetchProductDetails(){
if(listOfItems.isEmpty()) {
	initializeListItems();
	System.out.println("Item code   "+"Item Name  "+"Item Quantity  "+"Item Price");
	for(int i = 0; i < listOfItems.size(); i++) { 
		System.out.println("    "+ (i+1) + "         " + listOfItems.get(i).getItemName() + "         " + listOfItems.get(i).getQuantity()+"             "+ listOfItems.get(i).getPrice());
	}
}
else{
	System.out.println("Item code   "+"Item Name  "+"Item Quantity  "+"Item Price");
	for(int i = 0; i < listOfItems.size(); i++) { 
		System.out.println("    "+ (i+1) + "         " + listOfItems.get(i).getItemName() + "         " + listOfItems.get(i).getQuantity()+"             "+ listOfItems.get(i).getPrice());
	}
}
System.out.println("Write item code to add to cart");
int productCode = sc.nextInt();
int itemQuantity = 1;
int itemCode = listOfItems.get(productCode-1).getproductCode();
String itemName = listOfItems.get(productCode-1).getItemName();
double itemPrice = listOfItems.get(productCode-1).getPrice();
Product product = new Product(itemCode,itemName,itemQuantity,itemPrice);
return product;
	}
}

