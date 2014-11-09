package com.zlate87;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zlatko on 11/8/2014.
 */
public class Util {

  public static Set<String> arrayToSet(String[] a) {
    Set<String> set = new HashSet<String>();
    for (int i = 0; i < a.length; i++) {
      set.add(a[i]);
    }

    return set;
  }
}
