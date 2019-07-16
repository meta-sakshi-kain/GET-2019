import java.util.Scanner;
//class to perform operations on strings
public class OperationsOnStrings {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {
		boolean quit=false;
		System.out.println("Select an option to perform following tasks:");
int choice=0;
do {
	System.out.println("1.Are the strings equal.");
	System.out.println("2.Reverse the given string.");
	System.out.println("3.Replace lowercase characters with uppercase and vice-versa of the given string.");
	System.out.println("4.Get the largest word of the string.");
	System.out.println("5.Exit.");
	try {
		choice = sc.nextInt();
	} catch (Exception e) {
		System.out.println("invalid action");
	}
	sc.nextLine();
	switch(choice) {
	case 1:
		String firstString;
		String secondString;
		System.out.println("Enter first string");
		firstString=sc.nextLine();
		System.out.println("Enter second string");
		secondString=sc.nextLine();
		System.out.println(stringEquality(firstString,secondString));
		break;
	case 2:
		System.out.println("Enter a string to reverse");
		String original = sc.next();
		System.out.println(reverseString(original));
		break;
	case 3:
		String originalString;
		originalString=sc.nextLine();
		System.out.println(caseConversion(originalString));;
		break;
	case 4:
		System.out.println("Enter the sentence");
			String string = new Scanner(System.in).nextLine();  
			System.out.println(largestWord(string));
			break;
		case 5:
			quit=true;
			break;
		}
	}while(!quit);

}
/**
 * @param firstString is string to be compared
 * @param secondString is string to be compared
 * @return 1 if equal else return 0
 */
public static int stringEquality(String firstString,String secondString) {

	for (int i = 0; i < firstString.length() && i < secondString.length(); i++) { 
		if ((int)firstString.charAt(i)==(int)secondString.charAt(i)) { 
			continue; 
		}
		else {
			return 0;
		}
	}
	return 1;	
}

/**
 * @param original is the original string
 * @return the reverse of original string. 
 */
public static String reverseString(String original) {
	int length = original.length();
	String reverse="";

	for ( int i = length - 1 ; i >= 0 ; i-- )
		reverse = reverse + original.charAt(i);
	return reverse;
}

/**
 * @param originalString is the string entered by user
 * @return converted string with lowercase characters to uppercase and vice-versa
 */
public static String caseConversion(String originalString) {
	String convertedString="";
for (int i = 0; i< originalString.length(); i++){
	char ch=originalString.charAt(i);

	if(ch>='A'&&ch<='Z')
	{
		ch=(char) ((int)ch+32);
		convertedString=convertedString+ch;

	}
	else if(ch>='a'&&ch<='z')
		{
			ch=(char) ((int)ch-32);
			convertedString=convertedString+ch;
		}
		else{
			convertedString=convertedString+ch;
		}
	}   
	return convertedString;

}

/**
 * @param string is the sentence entered by user
 * @return the largest word of a string. 
 */
public static String largestWord(String string) {

	char ch;
	String word="";
int currentLength;
int maxLength=0;
String largestWord="";
string = string + " ";   
for(int i=0;i<string.length();i++)
{
	ch=string.charAt(i);
	if(ch!=' ')
	{
		word=word+ch; 
	}
	else
	{
		currentLength=word.length();
		if(currentLength>=maxLength) 
		{
			maxLength=currentLength;
			largestWord=word;
		}
		word=""; 
			}
		}    
		return largestWord;
	}  
}

