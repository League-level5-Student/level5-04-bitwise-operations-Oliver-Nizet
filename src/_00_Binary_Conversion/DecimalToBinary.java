package _00_Binary_Conversion;

import javax.swing.JOptionPane;

public class DecimalToBinary {
	public static void main(String[] args) {
		//Converting a decimal number to binary is a little trickier.
		
		//EXAMPLE: Convert 43 to binary
		
		/*
		 * Step 1: Start with one and add a digit the left that is double the value of the previous number.
		 *         Stop when you've passed the target number        
		 *         eg. 43
		 *         	64	32	16	8	4	2	1
		 *        
		 *	Step 2: Remove the left most value (the one that is higher than the target). 
		 *			eg. 43
		 *         	32	16	8	4	2	1
		 *         
		 *  Step 3: Find the combination of values that add up to the target number.
		 *  		eg. 43
		 *         	32	16	8	4	2	1
		 *          43 = 32 + 8 + 2 + 1
		 *         
		 *  Step 4: Every matching number in the list is a 1, and non-matching is a 0.
		 *  		eg. 43
		 *         	32	16	8	4	2	1
		 *          43 = 32 + 8 + 2 + 1
		 *         
		 *          1    0   1   0   1   1
		 *          32	16	 8	 4	 2	 1
		 *         
		 *         43 in decimal is 101011 in binary!
		 */
		int dec = Integer.parseInt(JOptionPane.showInputDialog("Enter Decimal Number To Be Converted"));
		int top = 1;
		int len = 0;
		while(top<dec) {
			top*=2;
			len++;
		}
		char[] chars = new char[len];
		for(int i = 0; i < chars.length; i++) {
			top /= 2;
			if(dec>=top) {
				dec-=top;
				chars[i] = '1';
			} else {
				chars[i] = '0';
			}
		}
		String bin = new String(chars);
		JOptionPane.showMessageDialog(null, "Your Number Is " + bin + " In Binary");
	}
}
