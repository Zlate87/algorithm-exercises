package com.zlate87;

//'.' Matches any single character.
//        '*' Matches zero or more of the preceding element.
//
//        The matching should cover the entire input string (not partial).
//
//        The function prototype should be:
//        bool isMatch(const char *s, const char *p)
//
//        Some examples:
//        isMatch("aa","a") return false
//        isMatch("aa","aa") return true
//        isMatch("aaa","aa") return false
//        isMatch("aa", "a*") return true
//        isMatch("aa", ".*") return true
//        isMatch("ab", ".*") return true
//        isMatch("aab", "c*a*b") return true
public class LeetCode {

//  public static boolean isMatch(String s, String p) {
//
//    if(p.length() == 0)
//      return s.length() == 0;
//
//    //p's length 1 is special case
//    if(p.length() == 1 || p.charAt(1) != '*'){
//      if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
//        return false;
//      return isMatch(s.substring(1), p.substring(1));
//
//    }else{
//      int len = s.length();
//
//      int i = -1;
//      while(i<len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
//        if(isMatch(s.substring(i+1), p.substring(2)))
//          return true;
//        i++;
//      }
//      return false;
//    }
//  }

  public static boolean isMatch(String word, String expresion) {
    if (expresion.contains(".*")) {
      // this shit matches everything
      return true;
    }

    while (expresion.contains("**")) {
      expresion = expresion.replace("**", "*");
    }

    for (int i = 0; i < expresion.length(); i ++) {
      if (isMatching(word, expresion.substring(i))) {
        return true;
      }
    }

    return false;
  }

  private static boolean isMatching(String word, String expresion) {
    if (expresion.startsWith("*")) {
      return false;
    }
    int wordIndex = 0;
    for(int expressionIndex = 0; expressionIndex < expresion.length(); expressionIndex ++) {
      if (expresion.charAt(expressionIndex) == word.charAt(wordIndex)) {
        wordIndex++;
        continue;
      } else if (expresion.charAt(expressionIndex) == '.') {
        wordIndex++;
        continue;
      } if (expresion.charAt(expressionIndex) == '*') {
        char previousChar = expresion.charAt(expressionIndex - 1);
        if (previousChar == word.charAt(wordIndex)) {
          while (word.length() > wordIndex && previousChar == word.charAt(wordIndex)){
            wordIndex++;
          }
          continue;
        }
      }

      // this is needed for example if we have word: aaaab and expression a*ab
      int numberOfCharsReplaced = 1;
      while (expressionIndex > numberOfCharsReplaced && expresion.charAt(expressionIndex - numberOfCharsReplaced) == '*'
              && expresion.charAt(expressionIndex - numberOfCharsReplaced - 1) == expresion.charAt(expressionIndex)) {
        numberOfCharsReplaced++;
        expressionIndex++;
      }
      if (numberOfCharsReplaced > 1) {
        expressionIndex--; // since it will get the needed ++ in the for incrementation
        continue;
      }

      wordIndex = 0;
    }
    return wordIndex == word.length();
  }

}
