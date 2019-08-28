package _04_Base64_Decoder;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class Base64Decoder {
	/*
	 * Base 64 is a way of encoding binary data using text. Each number 0-63 is
	 * mapped to a character. NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE
	 * ENCODING! Since the numbers 0 through 63 can be represented using 6 bits,
	 * every four (4) characters will represent twenty four (24) bits of data. 4 * 6
	 * = 24
	 * 
	 * For this exercise, we won't worry about what happens if the total bits being
	 * converted do not divide evenly by 24.
	 * 
	 * If one char is 8 bits, is this an efficient way of storing binary data?
	 * (hint: no)
	 * 
	 * It is, however, useful for things such as storing media data inside an HTML
	 * file (for web development), so that way a web site does not have to look for
	 * an image, sound, library, or whatever in a separate location.
	 * 
	 * View this link for a full description of Base64 encoding
	 * https://en.wikipedia.org/wiki/Base64
	 */

	public static void main(String[] args) {
		System.out.println(convert4CharsTo24Bits("454d"));
	}

	final static char[] base64Chars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', '+', '/' };

	// 1. Complete this method so that it returns the the element in
	// the base64Chars array that corresponds to the passed in char.
	public static byte convertBase64Char(char c) {
		for (byte i = 0; i < base64Chars.length; i++) {
			if (base64Chars[i] == c) {
				return i;
			}
		}
		return -1;
	}

	// 2. Complete this method so that it will take in a string that is 4
	// characters long and return an array of 3 bytes (24 bits). The byte
	// array should be the binary value of the encoded characters.
	public static byte[] convert4CharsTo24Bits(String s) {
		char[] chars = s.toCharArray();
		String[] bits6 = new String[4];
		for (int a = 0; a < 4; a++) {
			int n = convertBase64Char(chars[a]);
			int[] binaryNum = new int[1000];
			int i = 0;
			while (n > 0) {
				binaryNum[i] = n % 2;
				n = n / 2;
				i++;
			}
			String bin = "";
			for (int j = i - 1; j >= 0; j--) {	
				bin += binaryNum[j];
			}
			while(bin.length()<6) {
				bin = "0" + bin;
			}
			bits6[a] = bin;
			System.out.println(bits6[a]);
		}
		String bitsall = "";
		for(String b6 : bits6) {
			bitsall += b6;
		}
		System.out.println(bitsall);
		String[] bits8 = new String[3];
		bits8[0] = bitsall.substring(0,8);
		bits8[1] = bitsall.substring(8,16);
		bits8[2] = bitsall.substring(16,24);
		for(String b8 : bits8) {
			System.out.println(b8);
		}
		byte[] bytes = new byte[3];
		int i0 = Integer.parseInt(bits8[0],2);
		int i1 = Integer.parseInt(bits8[1],2);
		int i2 = Integer.parseInt(bits8[2],2);
		bytes[0] = (byte) i0;
		bytes[1] = (byte) i1;
		bytes[2] = (byte) i2;
		return bytes;
	}

	// 3. Complete this method so that it takes in a string of any length
	// and returns the full byte array of the decoded base64 characters.
	public static byte[] base64StringToByteArray(String file) {
		return null;
	}
}
