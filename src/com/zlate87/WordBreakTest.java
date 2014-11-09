package com.zlate87;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zlatko on 11/8/2014.
 */
public class WordBreakTest {

  @Test
  public void test() {

    Assert.assertEquals(true, WordBreak.wordBreak("julezlatko", Util.arrayToSet(new String[]{"julez", "jule", "zlatko"})));
  }




}
