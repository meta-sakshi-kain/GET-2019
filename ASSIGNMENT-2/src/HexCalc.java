import java.util.Scanner;

//class for performing operations on hexadecimal numbers
public class HexCalc {
//Function to get the first hex number
public static String getfirstHexNum(){
	String firstHexNumber;
	System.out.println("Enter first hexadecimal number");
	firstHexNumber=sc.next();
	return firstHexNumber;
}

//Function to get second hex number
public static String getsecondHexNum(){
	String secondHexNumber;
	System.out.println("Enter second hexadecimal number");
	secondHexNumber=sc.next();
	return secondHexNumber;
}

public static Scanner sc=new Scanner(System.in);
public static void main(String args[]){
// Menu to perform operations on HexaDecimal numbers
System.out.println("Choose an option from below to perform an operation");
 int choice;
do{
System.out.println("1.Add two HexaDecimal numbers.");
System.out.println("2.Subtract two HexaDecimal numbers.");
System.out.println("3.Multiply two HexaDecimal numbers.");
System.out.println("4.Divide two HexaDecimal numbers.");
System.out.println("5.Are these two HexaDecimal numbers equal?");
System.out.println("6.Is first number greater than second?");
System.out.println("7.Is first number less than second?");
System.out.println("8.Exit");
choice=sc.nextInt();
switch(choice)
{
case 1:
	addHexNumbers();
	break;
case 2:
	subtractHexNumbers();
	break;
case 3:
	multiplyHexNumbers();
	break;
case 4:
	divideHexNumbers();
	break;
case 5:
	System.out.println(equality());
	break;
case 6:
	System.out.println(greaterHexNumber());
	break;
case 7:
	System.out.println(smallerHexNumber());
	break;
case 8:
	System.exit(0);
	break;
default:
	System.out.println("Enter a valid option");
}
}while(choice!=8);
}

//HexaDecimal to Decimal conversion
static int hexToDecimal(String hexVal) 
{    
int len = hexVal.length(); 
int base = 1; 
int decVal = 0; 
int hexBase=16;
for (int i=len-1; i>=0; i--) 
{    
if (hexVal.charAt(i) >= '0' && hexVal.charAt(i) <= '9') 
{ 
	decVal += (hexVal.charAt(i) - 48)*base; 
	base = base * hexBase; 
} 
else if (hexVal.charAt(i) >= 'A' && hexVal.charAt(i) <= 'F') 
{ 
	decVal += (hexVal.charAt(i) - 55)*base; 
	base = base* hexBase; 
} 
if(decVal>0){

}else{
	System.out.println("Enter a valid HexaDecimal Number");
	System.exit(0);
}
} 
return decVal; 
}

//Decimal to HexaDecimal conversion function
public static String decimalToHex(long product){    
int rem;  
String hex="";  
int base=16;
char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  
while(product>0)  
{  
	rem=(int) (product%base);   
	hex=hexchars[rem]+hex;   
	product=product/base;  
}  
return hex;  
}   

//Function to add two hexaDecimal numbers
public static void addHexNumbers()  
{ 
    int sum=hexToDecimal(getfirstHexNum())+hexToDecimal(getsecondHexNum());
	System.out.println(decimalToHex(sum));
}

//Function to subtract two hexaDecimal numbers
public static void subtractHexNumbers()  
{ 
int difference=hexToDecimal(getfirstHexNum())-hexToDecimal(getsecondHexNum());
if(difference<0)
System.out.println("Enter first number greater than second");
System.out.println(decimalToHex(difference)); 
} 

//Function to get product of two hexaDecimal numbers
public static void multiplyHexNumbers()
{
long product=(long)hexToDecimal(getfirstHexNum())*(long)hexToDecimal(getsecondHexNum());
System.out.println(decimalToHex(product));
}

//Function to divide two hexaDecimal numbers
public static void divideHexNumbers()
{
int divide=hexToDecimal(getfirstHexNum())/(hexToDecimal(getsecondHexNum()));
System.out.println(decimalToHex(divide));
 if(divide<1)
  System.out.println("Enter first number greater than second");
}

//Function to check that the hexaDecimal numbers are equal or not
public static boolean equality(){
String firstHexNumber=removeZero(getfirstHexNum().toUpperCase());
String secondHexNumber=removeZero(getsecondHexNum().toUpperCase());
boolean result=true;
if((firstHexNumber.length())==(secondHexNumber.length())){
	for(int i=0;i<firstHexNumber.length();i++){
		if((firstHexNumber.charAt(i))!=(secondHexNumber.charAt(i))){
			result=false;
		}
	}
}
	return result;
}

//Is first HexaDecimal number greater than the second one
public static boolean greaterHexNumber(){
	String firstHexNumber=removeZero(getfirstHexNum());
	String secondHexNumber=removeZero(getsecondHexNum());
	boolean result=true;
	//if the length of first string is greater than second string it is smaller than first string
if(firstHexNumber.length()>secondHexNumber.length()){
	return result;
}

//if length of both the strings is equal compare each character
else if((firstHexNumber.length())==(secondHexNumber.length()))
{
for(int i=0;i<firstHexNumber.length();i++){
	if((firstHexNumber.charAt(i))>(secondHexNumber.charAt(i)) ){
		return result;
	}
	else {
		result=false;
}
}
}
return result;
}

//Is first HexaDecimal number smaller than the second one
public static boolean smallerHexNumber(){
String firstHexNumber=removeZero(getfirstHexNum());
String secondHexNumber=removeZero(getsecondHexNum());
boolean result=true;
//if the length of first string is smaller than second string it is smaller than first string
if(firstHexNumber.length()<secondHexNumber.length()){
	return result;
}
//if length of both the strings is equal compare each character
else if((firstHexNumber.length())==(secondHexNumber.length()))
{
for(int i=0;i<firstHexNumber.length();i++){
if((firstHexNumber.charAt(i))<(secondHexNumber.charAt(i)) ){
	return result;
}
else {
	result=false;
}
}
}
	return result;
}

//Function to remove zeroes from string
public static String removeZero(String hexNum){
StringBuilder newHex=new StringBuilder();
int i;
for(i=0;i<hexNum.length();i++){
	if(hexNum.charAt(i)=='0')
		continue;
	else
		break;
}
for(int j=i;j<hexNum.length();j++)
	newHex.append(hexNum.charAt(j));
return (newHex.toString());
}
}

