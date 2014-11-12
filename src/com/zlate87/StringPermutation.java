package com.zlate87;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zlatko on 11/12/2014.
 */
public class StringPermutation {

  public static void main(String[] args) {
    stringPermutation("abc");
  }

  public static List<String> stringPermutation(String s) {
    List<String> inPermutations = new ArrayList<String>();
    inPermutations.add(s);
    List<String> outPermutations = permutate(inPermutations, 0, s.length());

    for(String permutation : outPermutations) {
      System.out.println(permutation);
    }

    return outPermutations;
  }

  private static List<String> permutate(List<String> inPermutations, int start, int end) {
    List<String> outPermutations = new ArrayList<String>();
    if (start == end) {
      outPermutations.addAll(inPermutations);
      return outPermutations;
    }
    for (String s : inPermutations) {
      for (int i = start; i < end; i++) {
        outPermutations.add(swap(s, start, i));
      }
    }


    return permutate(outPermutations, start + 1, end);
  }

  private static String swap(String s, int start, int i) {
    char[] c = s.toCharArray();
    char temp = c[start];
    c[start] = c[i];
    c[i] = temp;
    String swappedString = new String(c);
    return swappedString;
  }


}
