package com.zlate87;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 * Test class for KnightPathInChess.
 */
public class KnightPathInChessTest {

  @Test
  public void test() {
    assertEquals(6, new KnightPathInChess().findShortestPath("A1", "H8"));
    assertEquals(2, new KnightPathInChess().findShortestPath("e2", "e4"));
    assertEquals(4, new KnightPathInChess().findShortestPath("a1", "b2"));
    assertEquals(2, new KnightPathInChess().findShortestPath("b2", "c3"));
    assertEquals(6, new KnightPathInChess().findShortestPath("a1", "h8"));
    assertEquals(5, new KnightPathInChess().findShortestPath("a1", "h7"));
    assertEquals(6, new KnightPathInChess().findShortestPath("h8", "a1"));
    assertEquals(1, new KnightPathInChess().findShortestPath("b1", "c3"));
    assertEquals(0, new KnightPathInChess().findShortestPath("f6", "f6"));
  }
}
