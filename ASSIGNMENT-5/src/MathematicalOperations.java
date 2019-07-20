
public class MathematicalOperations {
/**
 * @param num1 represents first number
 * @param num2 represents second number
 * @return lcm of numbers
 */
public static int lcm(int num1,int num2){

	return num1*num2/hcf(num1,num2);
}
/**
 * @param num1 represents first number
 * @param num2 represents second number
 * @return hcf of the numbers
 */
public static int hcf(int num1,int num2){

if(num1==0)
	return num2;
else if(num2==0)
	return num1;
else
	return hcf(num2%num1,num1);
}
}

