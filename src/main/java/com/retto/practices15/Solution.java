package com.retto.practices15;

// https://leetcode.com/problems/palindrome-number/description/
class Solution {
	// Method 1: Using integer to string conversion
    public boolean isPalindrome_String(int x) {
        String inputString = Integer.toString(x);
        char[] array = inputString.toCharArray();

        int lastIndex = array.length-1;
        for(int i=0; i < array.length/2; i++) {
            if(array[i] != array[lastIndex-i]) {
                return false;        
            }
        }

        return true;
    }

    // Method 2: Using modulo (%) operator
    // Follow up: Could you solve it without converting the integer to a string?
    public boolean isPalindrome(int x) {
        int original = x;
        int collect = 0;

        if(x < 0)
            return false;

        while(x != 0) {
            int mod = x % 10;
            if(x > 9) {
                collect *= 10;
                collect += (mod * 10);
            } else {
                collect += mod;
            }
            x = (x-mod)/10;
        }

        return original == collect;
    }
}