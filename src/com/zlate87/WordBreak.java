package com.zlate87;

import java.util.Set;

//Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of
// one or more dictionary words.
//
//        For example, given
//        s = "leetcode",
//        dict = ["leet", "code"].
//
//        Return true because "leetcode" can be segmented as "leet code".
public class WordBreak {

  public static boolean wordBreak(String word, Set<String> dictionary) {
    // 0 -> we can get to the first char, 1 -> we can get to the second char, world.length -> last char
    // +1 because we need to get not to the last char, but after it.
    boolean[] canWeGetToHere = new boolean[word.length() + 1];

    // we can get to the first char
    canWeGetToHere[0] = true;

    for (int subWordStartIndex = 0; subWordStartIndex < word.length(); subWordStartIndex++) {
      if (!canWeGetToHere[subWordStartIndex]) {
        // if we can get to this char, no point of evaluating
        continue;
      }

      for(String wordForDictionary : dictionary) {
        int subWordEndIndex = subWordStartIndex + wordForDictionary.length();
        if (subWordEndIndex > word.length()) {
          continue;
        }

        String subWord = word.substring(subWordStartIndex, subWordEndIndex);
        if (subWord.equals(wordForDictionary)) {
          canWeGetToHere[subWordEndIndex] = true;
        }
      }
    }

    return canWeGetToHere[word.length()];
  }
}
