import java.util.ArrayList;
import java.util.List;


public class ArrOperation {
/**
 * @param inputArray represents array of positive numbers
 * @return size of the largest mirror section of inputArray
 */
public static int maxMirror(int inputArray[]){
int max=0,count=0;//max that hold maximum of the count
if(inputArray.length!=0) //check array is empty
{
	for(int i=0;i<=inputArray.length-1;i++)
	{
		for(int j=i+1;j<=inputArray.length-1;j++)
		{
			if(inputArray[i]==inputArray[j])//comparing each number with every other to find a match
			{
				for(int k=i,l=j;k<=l;k++,l--) //to find the length of the mirror
				{
					if(inputArray[k]==inputArray[l])
					{
						count++;
						if(k==l)
							count=count*2-1;
					}
					else{
						break;//break if the mirror ends
					}
				}
				if(count>max)
				{
					max=count;//updating max with the maximum of count
				}
				count=0;
			}
		}
	}
	return max;//value of maximum mirror section
}else
	throw new AssertionError("Array is empty");
}
/**
 * @param inputArray represents array of positive numbers 
 * @return  number of clumps in inputArray
 */
public static int countClumps(int inputArray[]) 
{
int current = -1, clump = 0;
if(inputArray.length!=0)//check array is empty
{         
	for(int i = 0; i < inputArray.length - 1; i++) 
	{
		if(inputArray[i] == inputArray[i + 1] && inputArray[i] != current) 
		{
			current = inputArray[i];   //store current value
			clump++;   //increase clump value
		} 
		else 
		{
			if(inputArray[i] != current) 
			{
				current = -1;//reset current value
			}
		}
	}
	return clump;
}else
	throw new AssertionError("Array is empty");
}
/**
 * @param inputArray array of positive numbers 
 * split index there sum of numbers on one side is equal to sum of numbers on other side
 * @return  split index if it exist else return -1
 */
public static int splitArray(int inputArray[]){
if(inputArray.length!=0)//check array is empty
{
	int sumFromLeft=inputArray[0];//set first value of array
	int sumFromright=inputArray[inputArray.length-1];//set last value of array
	int i=1,j=inputArray.length-2;
	while(i<=j){
		//check for split index
		if(sumFromLeft>=sumFromright){
			sumFromright+=inputArray[j];
			j--;
		}else if(sumFromright>sumFromLeft){
			sumFromLeft+=inputArray[i];
			i++;
		}
	}
	if(sumFromLeft==sumFromright&&j>=0)//check sum of both side
		return i;//return split index
	else
		return -1;
}else
	throw new AssertionError("Array is empty");
}
/**
 * @param inputArray array of positive numbers
 * @param x is a number
 * @param y is a number
 * @return array in which x is followed by y
 */
public static int[] fixXY(int inputArray[], int x, int y){
int count = 0;                                 //count of x in array
List<Integer> xList = new ArrayList<Integer>();  //for storing indexes of x
List<Integer> yList = new ArrayList<Integer>();  //for storing indexes of y
if(inputArray.length != 0){                           //check array is empty
	for(int i = 0; i <inputArray.length; i++){
		if(inputArray[i] == x){
			xList.add(i);                      //store index of x
			count++;
		}else if(inputArray[i] == y)
			yList.add(i);                     //store index of y
	}
	if(xList.contains(inputArray.length-1)){         //check x on last index
		throw new AssertionError("X occurs at the last index");
	}
	for(int i = 0; i<count-1 ; i++){              //check two adjacent x
		if(xList.get(i)+1 == xList.get(i+1))
			throw new AssertionError(" two adjacent X values");
	}
	if(xList.size() == yList.size()){          //check equal x and y
		for(int i=0 ; i<count ; i++){
			//swapping position of y in array
			int temp = inputArray[xList.get(i)+1];
			inputArray[xList.get(i)+1] = y;
			inputArray[yList.get(i)] = temp;
		}
		return inputArray;
	}else
		throw new AssertionError("unequal x & y");
}else
	throw new AssertionError("Array is empty");
}
}

