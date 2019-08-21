package _03_Printing_Binary;

import javax.swing.JOptionPane;

public class BinaryPrinter {
	//Complete the methods below so they print the passed in parameter in binary.
	//Don't be afraid to use the methods that are already complete to finish the others.
	//Create a main method to test your methods.
	public static void main(String[] args) {
		long s = 32;
		printLongBinary(s);
	}
	
	public void printByteBinary(byte b) {
		byte dec = b;
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
		System.out.print(bin);
		System.out.print(b);
	}
	
	public static void printShortBinary(short s) {
		short dec = s;
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
		System.out.print(bin);
	}
	
	public static void printIntBinary(int x) {
		int dec = x;
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
		System.out.print(bin);
	}
	
	public static void printLongBinary(long l) {
		long dec = l;
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
		System.out.print(bin);
	}
}
