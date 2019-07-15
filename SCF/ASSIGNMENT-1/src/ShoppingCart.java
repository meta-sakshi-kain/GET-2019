import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//ShoppingCart class for the items added to cart
public class ShoppingCart {
List<Product> cartItemsList = new ArrayList<Product>();
Scanner sc = new Scanner(System.in);

// add item to cart
public  void addItem(Product Product){
if (cartItemsList.isEmpty()){
cartItemsList.add(new Product(Product.getproductCode(),Product.getItemName(),1,Product.getPrice()));
}
else {
int checkProductCode = Product.getproductCode();
for(int i = 0; i < cartItemsList.size(); i++) {
if( checkProductCode==cartItemsList.get(i).getproductCode() ){
System.out.println("Item is already in cart. Update it's quantity by selecting 2 option.");
break;
}
else{
cartItemsList.add(new Product(Product.getproductCode(),Product.getItemName(),Product.getQuantity(),Product.getPrice()));
}
}
}
}
// show cart items
public void showCart(){
if(cartItemsList.isEmpty()){
System.out.println("Cart is empty!");
System.out.println();
}
else {
System.out.println("S.NO." + " " + "Product name" + " " + "Product quantity");
for(int i = 0; i < cartItemsList.size(); i++) {
System.out.println(i+1 + "      " + cartItemsList.get(i).getItemName() + "      " + cartItemsList.get(i).getQuantity());

}
System.out.println();
}
}

// update quantity of items
public void updateCart(){
if(cartItemsList.isEmpty()){
System.out.println("Cart is empty!");
System.exit(0);
}
System.out.println("Write the item number and updated quantity");
int itemNumber = sc.nextInt();
if((itemNumber-1) >= cartItemsList.size()) {
System.out.println("This item does not exist");
System.out.println();
return;
}
int updatedQuantity =sc.nextInt();
if(updatedQuantity == 0) {
cartItemsList.remove(itemNumber-1);	
}
else cartItemsList.get(itemNumber-1).setQuantity(updatedQuantity);


}



//generate bill of items in the cart
public void generateBill(){
if(cartItemsList.isEmpty()) {
System.out.println("The cart has no item");
System.out.println();
}
else {
System.out.println("Sr. No." + "  " + "Ïtem Name" + "  " + "Item Quantity" + "  " + "PricePerItem" + "  " + "totalPriceForEachItem");
double amount=0;
for(int i = 0; i < cartItemsList.size(); i++){
double totalPriceForEachItem = cartItemsList.get(i).getQuantity() * cartItemsList.get(i).getPrice();
System.out.println(i+1 + "        " + cartItemsList.get(i).getItemName() + "        " + cartItemsList.get(i).getQuantity() + "            " + cartItemsList.get(i).getPrice() + "            " + totalPriceForEachItem);
amount += totalPriceForEachItem;
}
System.out.println("Your Bill amount is" + " " + amount);
System.out.println();

}
}
}

