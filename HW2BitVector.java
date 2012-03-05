/**
 * This class represents a bit vector.
 * This class represents 32 (NEW) bits which can be manipulated 
 * through use of the methods this class provides.
 * 
 * (Note the rules are different than in the other java file)
 * The only things you are allowed to use in your code are the following
 *	    - The bitwise operators |, &, ~, ^, <<, >>
 *	    - Increment and Decrement ++, and --.  You may also use add things with 1 or subtract things with 1.
 *	    - Boolean operators ||, &&, and ! only in if statements
 *	    - Conditional statements (if, if-else, switch-case, ? :).
 *	    - Equality comparisons (==, !=, <=, >=, <, >).
 *	    - String concatenation (+) only in the toString method.
 *	    - Iteration may be used for onesCount, zerosCount, size, toString.
 *
 *	Anything not mentioned above you are not allowed to use. This includes the following but is not an exhaustive list:
 *	    - Multiplication & Division
 *	    - Addition & Subtraction with numbers other than 1.
 *      - Iteration in functions not mentioned above.
 *      - The unsigned right shift operator >>> (C does not provide this operator).
 *	    - Modulus (%)
 *	    - Any functions found in Java libraries (especially the Math library)
 *	        - Example Math.pow, Integer.bitCount, etc.
 *	    - Casting (you should not have cast anywhere!)
 *
 * @author Harrison English.
 *
 */
public class HW2BitVector
{
	/** 32 bit data initialized to all zeros Here is what you will be using to represent a Bit Vector */
	private int bits;
	/* You may not add any more fields to this class other than the ones given. */
	
	public static void main(String[] args)
	{
	    // Add your test cases here.
	    // Failure to add test cases will result in points taken off.
	    // You must test each function at least once.
            HW2BitVector test = new HW2BitVector();
            System.out.println("Empty Bit Vector");
            System.out.println(test);
            System.out.println("Bit Vector after set(1) method");
            test.set(1);
            System.out.println(test);
            System.out.println("Bit Vector after using setBitTo the 0,4,7 index true and the 1 index to false");
            test.setBitTo(0,true);
            test.setBitTo(4,true);
            test.setBitTo(7,true);
            test.setBitTo(1,false);
            System.out.println(test);
            System.out.println("Bit Vector after clear(0) method");
            test.clear(0);
            System.out.println(test);
            System.out.println("is index 2 set?");
            System.out.println(test.isSet(2));
            System.out.println("is index 2 cleared?");
            System.out.println(test.isClear(2));
            System.out.println("how many ones are there?");
            System.out.println(test.onesCount());
            System.out.println("How many zeroes are there?");
            System.out.println(test.zerosCount());
            System.out.println("what is the \"size\" of this BitVector?");
            System.out.println(test.size());
            
    }
	
	public HW2BitVector()
	{
		bits = 0;
	}
	
	/**
	 * Sets the bit (to 1) pointed to by index.
	 * @param index index of which bit to set.
	 *        0 for the least significant bit (right most bit).
	 *        31 for the most significant bit.
	 */
	public void set(int index)
	{
		//Shifts 1 bit over to the correct index and then OR's that number with
		//the current number of bits to make sure the bit at index is set to 1
		bits = bits|(1<<index);
	}

	/**
	 * Clears the bit (sets to 0) pointed to by index.
	 * @param index index of which bit to set.
	 * 	      0 for the least significant bit (right most bit).
	 * 	      31 for the most significant bit.
	 */

	public void clear(int index)
	{
		bits = bits&~(1<<index);
		
	}

	/**
	 * Sets the bit (to the value passed in) pointed to by index.
	 * @param index index of which bit to set.
	 * 	      0 for the least significant bit (right most bit).
	 * 	      31 for the most significant bit.
	 */
	public void setBitTo(int index, boolean value)
	{
		//If value is true then it sets the bit to 1 at index
		if(value)
			set(index);
		//If value is false then it sets the bit to 0 at index
		else
			clear(index);
		
	}
	
	/**
	 * Returns true if the bit pointed to by index is currently set.
	 * @param index index of which bit to check.  
	 * 	      0 for the least significant bit (right most bit).
	 * 	      31 for the most significant bit.
	 * @return true if the bit is set in any other case (including index >= 32) return false.
	 */
	public boolean isSet(int index)
	{	
		//creates a variable for the number created by have only a bit in the index
		int indexNumber = (1<<index);
		//test to see if index is outside range and returns false if it is
		if(index >= 32)	
			return false;
		//ANDs the current bits by a the index Number and Compares to see that that bit is set if it is it returns true
		if((bits&indexNumber)==indexNumber)
			return true;
		else
			return false;
	}
	
	/**
	 * Returns false if the bit pointed to by index is currently set.
	 * @param index index of which bit to check.  
	 * 	      0 for the least significant bit (right most bit).
	 * 	      31 for the most significant bit.
	 * @return false if the bit is set in any other case (including index >= 32) return true.
	 */
	public boolean isClear(int index)
	{
		//creates a variable for the number created by have only a bit in the index
		int indexNumber = (1<<index);
		//test to see if index is outside range and returns true if it is
		if(index >= 32)	
			return true;
		//ANDs the current bits by a the index Number and Compares to see that that bit is set if it is it returns false
		if((bits&indexNumber)==indexNumber)
			return false;
		else
			return true;
	}
	
	/**
	  * Returns the number of 1's current set in this bit vector.
	  * You may obviously use the ++ operator to increment your counter. 
	  */
	public int onesCount()
	{	
		//counter for number of 1s
		int num = 0;
		//iterator to go through each bit
		for(int i =0; i<31;i++) {
			//test to see if bit is a 1
			if(isSet(i)) {
				//adds 1 to total number of 1s if true
				num++;
			}
		}
		//returns total number of 1s
		return num;
	}
	
	/**
	  * Returns the number of 0's currently set in this bit vector.
	  * You may obviously use the ++ operator to increment your counter. 
	  */
	public int zerosCount()
	{
		//counter for number of 0s
		int num = 0;
		//iterator to go through each bit
		for(int i =0; i<32;i++) {
			//test to see if bit is a 0
			if(isClear(i)) {
				//adds 1 to total number of 0s if true
				num++;
			}
		}
		//returns total number of 1s
		return num;
	}
	
	/**
	 * Returns the "size" of this BitVector.  The size of this bit vector is defined
	 * to be the minimum number of bits that will represent all of the 1's for example
	 * the size of this bit vector 00010000 will be 5.
	 */
	public int size()
	{
		//index of msb(most significant bit)
		int index = 0;
		//iterator to go through each bit
		for(int i =index; i<32;i++) {
			//test to see if bit is a 1 and sets the index to that bit if it is
			if(isSet(i)) {
				index = i;
			}
		}
		
		//returns index of msb and adds 1 because you always need at least 1 bit to represent a number
		return index+1;
	}
	
	/**
	 * Returns a string representation of this object.
	 * Return a string with the binary representation of the bit vector.
	 * You may use String concatenation (+) here.
	 */
    @Override
	public String toString()
	{	
		//Blank string to hold binary
		String binNum = "";
		//iterator to go through each bit
		for(int i =0; i<32;i++) {
			//test to see if bit at the index is a 1 and adds the char "1" to the beginning of string if so
			if(isSet(i)) {
				binNum = "1"+binNum;
			}
			//adds char "0" to string if the bit is not set at the index
			else
				binNum = "0"+binNum;
		}
		//returns the binary string
		return binNum;
	}

	public int getBits()
	{
		return bits;
	}
}
