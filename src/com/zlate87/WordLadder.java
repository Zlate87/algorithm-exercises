package com.zlate87;

import java.util.HashSet;
import java.util.Set;

//Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to
// end, such that:
//
//        Only one letter can be changed at a time
//        Each intermediate word must exist in the dictionary
//        For example,
//
//        Given:
//        start = "hit"
//        end = "cog"
//        dict = ["hot","dot","dog","lot","log"]
//        As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//        return its length 5.
//
//        Note:
//        Return 0 if there is no such transformation sequence.
//        All words have the same length.
//        All words contain only lowercase alphabetic characters.
public class WordLadder {

  public static int ladderLength(String start, String end, Set<String> dict) {
    int minSteps = ladderLength(start, end, dict, 1);
    if (minSteps == Integer.MAX_VALUE) {
      minSteps = 0;
    }
    return minSteps;
  }
  public static int ladderLength(String start, String end, Set<String> dict, int steps) {
    steps++;
    if (canChangeWithOneLetter(start, end)) {
      return steps;
    }
    int minSteps = Integer.MAX_VALUE;
    for (String wordFromDictionary : dict) {
      if (canChangeWithOneLetter(start, wordFromDictionary)) {
        Set<String> subDict = getSubDict(dict, wordFromDictionary);
        int subSteps = ladderLength(wordFromDictionary, end, subDict, steps);
        if (minSteps > subSteps) {
          minSteps = subSteps;
        }
      }
    }
    return minSteps;
  }

  private static Set<String> getSubDict(Set<String> dict, String wordFromDictionary) {
    Set<String> subDict = new HashSet<String>();
    subDict.addAll(dict);
    subDict.remove(wordFromDictionary);
    return subDict;
  }

  private static boolean canChangeWithOneLetter(String start, String end) {
    int changes = 0;
    for (int i = 0; i < start.length(); i++) {
      if (start.charAt(i) != end.charAt(i)) {
        changes++;
        if (changes > 1) {
          return false;
        }
      }
    }
    return true;
  }
}
