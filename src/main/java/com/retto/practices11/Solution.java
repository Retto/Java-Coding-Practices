package com.retto.practices11;

public class Solution {
	private long result = 0;
	private boolean illegal = false;
	private boolean hasMinus = false;
	private boolean overflow = true;
	private int signCharacter = 0;
	private boolean firstDigitReceived = false;
	private boolean nonDigitCharacter = false;

	private void handleChar(char c) {
		switch (c) {
		case '-':
			if (firstDigitReceived) {
				illegal = true;
			} else {
				hasMinus = true;
			}
			signCharacter++;
			break;
		case '+':
			if (firstDigitReceived) {
				illegal = true;
			}
			signCharacter++;
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			firstDigitReceived = true;
			result *= 10;
			if (hasMinus) {
				result -= (c - 48); // char decimal value '0' ==> 48 '1' ==> 49
			} else {
				result += (c - 48); // char decimal value '0' ==> 48 '1' ==> 49
			}
			if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
				overflow = true;
			}
			break;
		case ' ':
			if (firstDigitReceived || signCharacter > 0) {
				illegal = true;
			}
			break;
		default:
			nonDigitCharacter = true;
			break;
		}
	}

	public int myAtoi(String s) {
		char[] input = s.toCharArray();
		result = 0;

		for (int i = 0; i < input.length; i++) {
			char c = input[i];
			handleChar(c);
			if (nonDigitCharacter || illegal || signCharacter > 1 || overflow) {
				break;
			}
		}

		if (overflow) {
			if (hasMinus) {
				result = Integer.MIN_VALUE;
			} else {
				result = Integer.MAX_VALUE;
			}
		}

		return (int) result;
	}

	public static void main(String[] args) {
		System.out.println((new Solution()).myAtoi("-2147483647"));
		System.out.println((new Solution()).myAtoi("-91283472332"));
		System.out.println((new Solution()).myAtoi("9223372036854775808"));
		System.out.println((new Solution()).myAtoi("-9223372036854775809"));
		System.out.println((new Solution()).myAtoi("+-12"));
	}
}
