package com.zlate87;

//Finding the longest palindromic substring
public class LongestPalindrome {

  public static String getLongestPalindrome(String s) {

    String longestPalindrome = "";
    for (int i = 0; i < s.length() - 2; i++) {
      for (int j = i + 1; j < s.length() - 1; j++) {
        String subString = s.substring(i, j);
        if (isPalindrome(subString) && subString.length() > longestPalindrome.length()) {
          longestPalindrome = subString;
        }
      }
    }
    return null;
  }

  public static boolean isPalindrome(String s) {
    for (int i = 0; i < s.length()/ 2; i ++) {
      if (s.charAt(i) != s.charAt(s.length() - i)) {
        return  false;
      }
    }
    return true;
  }
}
