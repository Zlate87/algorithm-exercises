package com.zlate87;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

import java.util.Set;

/**
 * Created by Zlatko on 11/8/2014.
 */
public class WordLadderTest {

  @Test
  public void test(){
    assertEquals(5, WordLadder.ladderLength("hit", "cog", Util.arrayToSet(new String[]{"hot", "dot", "dog", "lot", "log"})));
    assertEquals(0, WordLadder.ladderLength("hit", "zzz", Util.arrayToSet(new String[]{"hot", "dot", "dog", "lot", "log"})));
    assertEquals(7, WordLadder.ladderLength("aaa", "zzz", Util.arrayToSet(new String[]{"aab", "acb", "dcb", "dcz", "dzz"})));
    assertEquals(4, WordLadder.ladderLength("aaa", "acc", Util.arrayToSet(new String[]{"aab", "acb", "dcb", "dcz", "dzz"})));
  }
}
