
public class MathematicalOperations {
	public static int lcm(int num1,int num2){
	
		return num1*num2/hcf(num1,num2);
	}
	public static int hcf(int num1,int num2){
		
		if(num1==0)
			return num2;
		else if(num2==0)
			return num1;
		else
			return hcf(num2%num1,num1);
		
	}

}
