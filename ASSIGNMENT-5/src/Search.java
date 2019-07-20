public class Search {
/**
 * This method is a recursive function to apply linear search
 * @param inputArray is 1D array to which linear search is applied
 * @param num is the value to be searched in array
 * @return index position of the num in the array 
 */
public static int  dolinearSearch(int[] inputArray,int num){
	if(inputArray.length==0)
		throw new AssertionError("Empty Array");
	int index=linearSearch(inputArray,num,0 );
	return index;
}

/**
 * @param inputArray is 1D array to which linear search is applied
 * @param num is the value to be searched in array
 * @param index starting position of the array to be searched 
 * @return index position of element or recursively call the function linearSearch
 */
public static int linearSearch(int[] inputArray, int num, int index) {

	if(index==inputArray.length)
		return -1;
	else if(inputArray[index]==num)
		return index+1;
	else
		return linearSearch(inputArray, num, index+1);
}

/**
 * @param inputArray is 1D array to which linear search is applied
 * @param numSearch is the value to be searched in array
 * @return index of numSearch in the array
 */
public static int applyBinarySearch(int inputArray[],int numSearch)
{
	if(inputArray.length==0)
		throw new AssertionError("Array is empty");
	int index=binarySearch(inputArray,numSearch,0,inputArray.length-1);
	return index+1;
}

/*
 * This method is a recursive function to apply binary search
 * @param inputArray[] is the 1D array on which binary search is to be applied
 * @param numSearch is the number to be searched in the input array
 * @param start is the starting index of the input array from where the search is to be done
 * @param end is the ending index of the input array till where the search is to be done
 * @return int returns the index at which the number is found in the input array else returns -1
 */
  public static int binarySearch(int inputArray[],int numSearch,int start,int end)
  {
	  if(start>end)
		  return -1;
	  else
	  {
		  int mid=(start+end)/2;
		  if(inputArray[mid]==numSearch)
			  return mid;
		  else if(inputArray[mid]>numSearch)
			  end=mid-1;
		  else if(inputArray[mid]<numSearch)
			  start=mid+1;
		  return binarySearch(inputArray,numSearch,start,end);
	  }

  }
}





	
	

