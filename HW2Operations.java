/**
 * HW2 Part 2 - Coding with bitwise operators
 * 
 * (Note the rules are different than in the other java file).
 * The only operators you are allowed to use in your code are the following
 *	- The bitwise operators |, &, ~, ^, <<, >>
 *	- Increment and Decrement ++, and --.  You may also use add things with 1 or subtract things with 1.
 *	- Boolean operators ||, &&, and ! only in if statements
 *	- Conditional statements (if, if-else, switch-case, ? :).
 *	- Equality comparisons (==, !=).
 *
 * Anything not in the above list you are not allowed to use. This includes the following but is not an exhaustive list:
 *	- Multiplication & Division
 *	- Addition & Subtraction with numbers other than 1.
 *	- Modulus (%)
 *	- Iteration (for, while, do-while loops, recursion)
 *  - The unsigned right shift operator >>> (C does not provide this operator).
 *	- Any functions found in Java libraries (especially the Math library)
 *		- Example Math.pow, Integer.bitCount, etc.
 *	- Greater than and less than comparisons (>, <, >=, <=)
 *	- Casting (you should not have cast anywhere!)
 *
 * As a note all of these functions accept ints. Here is the reason
 * 1) If you pass in a number (which is of type int by default) into a function accepting a byte
 *    the Java compiler will complain even if the number would fit into that type.
 *    
 * Now keep in mind the return value is also an int.  Please read the comments on how many bits
 * to return and make sure the other bits are not set or else you will not get any points for that
 * test case. i.e if I say to return 6 bits and you return 0xFFFFFFFF you will lose points.
 *
 * Definitions of types
 * nibble (nybble) - 4 bits
 * byte - 8 bits
 * short - 16 bits
 * int - 32 bits
 * 
 * @author Harrison English
 * 
 */
public class HW2Operations
{
	
	public static void main(String[] args)
	{
		// Test your code here.
		// You should devise your own test cases here in addition to the ones in the comments.
		// Come up with one more test case than the ones given in the comments.
		
		//SetByte test cases 2 from comments + 1 self made
		System.out.println("---------Set Byte------------");
		System.out.println("Expected value is 0x25093418");
		int number = setByte(0x25093456, 0x18, 0);
		System.out.printf("Calculated value is 0x%x",number);
		System.out.println();
		System.out.println("Expected value is 0x12370F25");
		number = setByte(0x12374925, 0xF, 1);
		System.out.printf("Calculated value is 0x%x",number);
		System.out.println();
		System.out.println("Expected value is 0xFFFFBAFF");
		number = setByte(0xFFFFFFFF, 0xBA, 1);
		System.out.printf("Calculated value is 0x%x",number);
		System.out.println();
		
		//GetByte test cases 2 from comments + 1 self made
		System.out.println("---------Get Byte------------");
		System.out.println("Expected value is 0x78");
		number = getByte(0x12345678, 0);
		System.out.printf("Calculated value is 0x%x",number);
		System.out.println();
		System.out.println("Expected value is 0xFF");
		number = getByte(0xA55AFF25, 1);
		System.out.printf("Calculated value is 0x%x",number);
		System.out.println();
		System.out.println("Expected value is 0x6A");
		number = getByte(0x456ADB0F, 2);
		System.out.printf("Calculated value is 0x%x",number);
		System.out.println();

		//Pack test cases 2 from comments + 1 self made
		System.out.println("---------Pack------------");
		System.out.println("Expected value is 0x34687723");
		number = pack(0x3468, 0x7723);
		System.out.printf("Calculated value is 0x%x",number);
		System.out.println();
		System.out.println("Expected value is 0xBAADBEEF");
		number = pack(0xBAAD, 0xBEEF);
		System.out.printf("Calculated value is 0x%x",number);
		System.out.println();
		System.out.println("Expected value is 0x876345AF");
		number = pack(0x8763, 0x45AF);
		System.out.printf("Calculated value is 0x%x",number);
		System.out.println();
		
		//Unpack test cases 1 from comments + 1 self made
		System.out.println("---------Unpack------------");
		System.out.println("Expected value is 0x8, 0x7, 0x6, 0x5, 0x4, 0x3, 0x2, 0x1");
		int[] numberArray = unpack(0x12345678);
		System.out.print("Calculated value is ");
		for(int i:numberArray) {
			System.out.printf("0x%x",i);
			System.out.print(" ");
		}
		System.out.println();
		System.out.println("Expected value is 0x8, 0x9, 0xA, 0xB, 0xC, 0xD, 0xE, 0xF");
		numberArray = unpack(0xFEDCBA98);
		System.out.print("Calculated value is ");
		for(int i:numberArray) {
			System.out.printf("0x%x",i);
			System.out.print(" ");
		}
		System.out.println();
		
		//Negate test cases 4 from comments + 1 self made
		System.out.println("---------Negate------------");
		System.out.println("Expected value is 0x7FFFFF");
		number = negate(0x000001, 23);
		System.out.printf("Calculated value is 0x%x",number);
		System.out.println();
		System.out.println("Expected value is 0x000001");
		number = negate(0x7FFFFF, 23);
		System.out.printf("Calculated value is 0x%x",number);
		System.out.println();
		System.out.println("Expected value is 0x000000");
		number = negate(0x000000, 24);
		System.out.printf("Calculated value is 0x%x",number);
		System.out.println();
		System.out.println("Expected value is 0x3");
		number = negate(0x1, 2);
		System.out.printf("Calculated value is 0x%x",number);
		System.out.println();
		System.out.println("Expected value is 0xF0000000");
		number = negate(0x10000000, 32);
		System.out.printf("Calculated value is 0x%x",number);
		System.out.println();
		
		//Sign Extend test cases 2 from comments + 1 self made
		System.out.println("---------Sign Extend------------");
		System.out.println("Expected value is 0x000000D2");
		number = signExtend(0x000000D2, 9, 32);
		System.out.printf("0x%x",number);
		System.out.println();
		System.out.println("Expected value is 0xFFFFFFE4");
		number = signExtend(0x000007E4, 11, 32);
		System.out.printf("0x%x",number);
		System.out.println();
		System.out.println("Expected value is 0x7FFFFAE4");
		number = signExtend(0x00001AE4, 13, 31);
		System.out.printf("0x%x",number);
		System.out.println();
		
		
		
		
	}
	
	/**
	 * Sets a byte in a integer
	 * 
	 * Integers are made of four bytes, numbered like so: 33333333 22222222 11111111 00000000
	 *
	 * For a graphical representation of this:
	 *    3                   2                   1                 
	 *  1 0 9 8 7 6 5 4 3 2 1 0 9 8 7 6 5 4 3 2 1 0 9 8 7 6 5 4 3 2 1 0
	 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
	 * |     Byte3     |     Byte2     |     Byte1     |     Byte0     |
	 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
	 * 
	 * 
	 * Examples:
	 *      setByte(0x25093456, 0x18, 0) //=> 0x25093418
	 *      setByte(0x12374925, 0xF, 1)  //=> 0x12370F25
	 * 
	 * @param num integer that will be modified
	 * @param b byte to insert into the integer
	 * @param which determines which byte gets modified - 0 for least significant byte
	 *            
	 * @return the modified integer
	 */
	public static int setByte(int num, int b, int which)
	{
		//switches which byte you alter based on variable which (0-3)
		switch(which){
			//for each case it zeroes out the byte you want to alter
			//then it ORs it with the byte you want it to be creating that byte in the sequence
			case 0:
				num= num&0xFFFFFF00;
				num= num|b;
				break;
			//For cases 1-3 it shifts the byte you want to have over to the correct corresponding spots
			case 1:
				num= num&0xFFFF00FF;
				num= num|(b<<8);
				break;
			case 2:
				num= num&0xFF00FFFF;
				num= num|(b<<16);
				break;
			case 3:
				num= num&0x00FFFFFF;
				num= num|(b<<24);
				break;
		}
		//returns the new number you created		
		return num;
	}
	
	/**
	 * Gets a byte from an integer
	 * 
	 * Other examples: i.e. 
	 * getByte(0x12345678, 0) //=> 0x78
	 * getByte(0xA55AFF25, 1) //=> 0xFF
	 * 
	 * @param num an integer
	 * @param which Determines which byte gets returned - 0 for least significant byte
	 *            
	 * @return a byte corresponding 
	 */
	public static int getByte(int num, int which)
	{
		//switches which byte you alter based on variable which (0-3)
		switch(which){
			//for each case it zeroes out except for the byte you want
			case 0:
				num= num&0x000000FF;
				break;
			//For cases 1-3 it shifts the byte all the way down so there is a correct number of following zeroes
			case 1:
				num= num&0x0000FF00;
				num= num>>8;
				break;
			case 2:
				num= num&0x00FF0000;
				num= num>>16;
				break;
			case 3:
				num= num&0xFF000000;
				num= num>>24;
				break;
		}
		//returns Just the Byte you wanted		
		return num;
	}

	/**
	 * Packs 2 shorts (16 bits) into an int (32 bits)
	 * 
	 * The shorts should be placed consecutively in the integer in the order
	 * specified in the parameters.
	 * 
	 * i.e. pack(0x3468, 0x7723) //=> 0x34687723 
	 *      pack(0xBAAD, 0xBEEF) //=> 0xBAADBEEF
	 * 
	 * @param c1 most significant short (will always be an 16 bit number)
	 * @param c2 2nd short (will always be an 16 bit number)
	 *            
	 * @return an int formatted like so c1c2
	 */
	public static int pack(int c1, int c2)
	{
		//Shifts c1 over 16 bits to be the most significant short
		c1 = c1<<16;
		//returns c1 ORed with c2 creating the new int
		return c1|c2;
	}
	
	/**
	 * Unpacks an integer into 8 nibbles (4 bits) most significant nibble first.
	 * 
	 * i.e unpack(0x12345678) //=> {0x1, 0x2, 0x3, 0x4, 0x5, 0x6, 0x7, 0x8}
	 *  
	 * @param num integer that needs to be unpacked
	 * @return an array with each nibble of the integer most significant nibble first.
	 */
	public static int[] unpack(int num)
	{
		int[] answer = {0, 0, 0, 0, 0, 0, 0, 0};
		//sets each element by zeroing all of the bits other than the appropriate nibble for the each place and then shifts it over
		//until it is in the spot of the least significant nibble at which point it places into the array
		answer[0] = num&0x0000000F;
		answer[1] = (num&0x000000F0)>>4;
		answer[2] = (num&0x00000F00)>>8;
		answer[3] = (num&0x0000F000)>>12;
		answer[4] = (num&0x000F0000)>>16;
		answer[5] = (num&0x00F00000)>>20;
		answer[6] = (num&0x0F000000)>>24;
		answer[7] = (num&0xF0000000)>>28;
		
		//makes it act as an unsigned shift so you dont have repeated 1s before the byte you want.
		if(answer[7] < 0x0) {
			answer[7] = answer[7]^0xFFFFFFF0;
		}
		
		//returns the array
		return answer;
	}

	/**
	 * Negates an 'x' bit number.
	 * 
	 * Examples:
	 *      negate(0x000001, 23) //=> 0x7FFFFF
	 *      negate(0x7FFFFF, 23) //=> 0x000001
	 *      negate(0x000000, 24) //=> 0x000000
	 *      negate(0x1, 2) //=> 0x3 
	 * 
	 * @param num 2's complement 'x' bit number to negate.
	 * @param 'x' number of bits num is
	 * @return the negated version an 'x' bit binary number.
	 */
	public static int negate(int num, int x)
	{
		//verifies 0 stays 0
		if(num == 0)
			return 0;
			
		//shifts all 1s over by the number of bits num is and then flips it so that there are only 
		//1s for the number of bits num is.
		x= ~((0xFFFFFFFF<<(x-1))<<1);
		//Flips all of the bits in num and then adds 1 computing what is basically 2s compliment.
		return ((num^x)+0x1);
	}

	/**
	 * Sign extends an 'x' bit value to a 'y' bit value
	 * 
	 * Both the parameter and return value are ints, but the parameter only uses the least significant
	 * x bits, and the return value only uses the least significant y bits (the rest are zeros)
	 * 
	 * Examples:
	 *  signExtend(0x000000D2, 9, 32) results in 0x000000D2
	 * 	signExtend(0x000007E4, 11, 32) results in 0xFFFFFFE4
	 * 
	 * @param num an x bit 2's complement number
	 * @param x the original bit length
	 * @param y the new bit length
	 * @warning You will be guaranteed y > x.  If this precondition does not hold results are undefined.
	 * @return a 'y' bit 2's complement number, the sign extended value of num.
	 */
	public static int signExtend(int num, int x, int y)
	{
	
		//creates a variable for the number created by have only a bit in the index
		int indexNum = (1<<(x-1));
		
		//take all 1s and shift them y times then negate it so that there is only 1s the size of y
		int yNum = ~((0xFFFFFFFF<<(y-1))<<1);
		
		//XOR it with all 1s in the size of x which creates all 1s in front of the places of the original number
		int newNumSize = yNum^(~(0xFFFFFFFF<<x));
		
		//test if the most sig bit is a 1 and there negative a which point it XORs it with the newNumSize creating all 1s 
		//in front of the previous most sig bit
		if((num&indexNum)==indexNum) {
			return (num^newNumSize);
		}
		//else it places all 0s in front of the most sig bit (not really nessicary since java already places all leading bits
		//as zeroes to fill up the full space of an int)
		else {
			return num&(~newNumSize);
		}
		//return num;
	}
}
