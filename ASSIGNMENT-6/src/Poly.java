
public final class Poly {
	// immutable array
	private final int[] array;

	public Poly(int[] array) {
		this.array = array;
	}

	// access the array of class
	public int[] getArray() {
		return array;
	}

	/**
	 * @param x value of variable
	 * @return result of evaluation of polynomial equation
	 */
	public float evaluate(float x) {
		// set degree of polynomial
		int degree = degree();
		float result = 0;
		for (int i = 0; i <= degree; i++)
			result += (float) (array[i] * Math.pow(x, degree - i));
		return result;
	}

	/**
	 * @return degree of polynomial
	 */
	public int degree(){
		return array.length-1;
	}

	/**
	 * @param p1 first polynomial
	 * @param p2 second polynomial
	 * @return sum of the polynomials p1 and p2
	 */
	public static Poly addPoly(Poly p1, Poly p2) {
		// degree of arrays of p1 and p2
		int length1 = p1.degree() + 1;
		int length2 = p2.degree() + 1;
		// set big degree between p1 and p2
		int bigLength = length1 >= length2 ? length1 : length2;
		// polynomial of size of big degree
		int[] newPolyArray = new int[bigLength];
		// put big degree polynomial to new polynomial
		if (bigLength == length1)
			newPolyArray = p1.getArray();
		else
			newPolyArray = p2.getArray();
		for (int i = Math.abs(length2 - length1); i < bigLength; i++) {
			// add small degree polynomial to new polynomial
			if (bigLength == length1)
				newPolyArray[i] += p2.getArray()[i - 1];
			else
				newPolyArray[i] += p1.getArray()[i - 1];
		}
		// return sum of the polynomials p1 and p2
		return new Poly(newPolyArray);
	}

	/**
	 * @param p1 first polynomial
	 * @param p2 second polynomial
	 * @return product of the polynomials p1 and p2
	 */
	public static Poly multiplyPoly(Poly p1, Poly p2) {
		// degree of polynomials
		int degreeOfP1 = p1.degree();
		int degreeOfP2 = p2.degree();
		// arrays of polynomials
		int[] arrayOfP1 = p1.getArray();
		int[] arrayOfP2 = p2.getArray();
		// length of multiple array
		int lenOfArr = degreeOfP1 + degreeOfP2 + 1;
		int[] multipleArray = new int[lenOfArr];
		if (degreeOfP1 > degreeOfP2) 
			// if degree of p1 is greater
			multiple(degreeOfP1,degreeOfP2,multipleArray,arrayOfP1,arrayOfP2);
		else
			multiple(degreeOfP2,degreeOfP1,multipleArray,arrayOfP2,arrayOfP1);
		return new Poly(multipleArray);

	}
	
	/**
	 * @param bigDegree larger degree
	 * @param smallDegree smaller degree
	 * @param multipleArray result array of multiple
	 * @param array1 of larger degree
	 * @param array2 of smaller degree
	 */
	private static void multiple(int bigDegree, int smallDegree, int[] multipleArray, int[] array1,int[] array2 ){
		for (int i = 0; i <= bigDegree; i++) {
			for (int j = 0; j <= smallDegree; j++)
				// multiple coefficient
				multipleArray[(i + j)] = (multipleArray[(i + j)] + (array1[i] * array2[j]));
		}
	}

}
