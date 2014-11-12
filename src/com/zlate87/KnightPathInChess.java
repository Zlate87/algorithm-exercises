package com.zlate87;

/**
 * Find the Knight's Shortest Path in Chess for given start and end position.
 */
public class KnightPathInChess {

  public static final int BOARD_SIZE = 8;
  public int[][] chessBoard = new int[BOARD_SIZE][BOARD_SIZE];

  public KnightPathInChess () {
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
        chessBoard[i][j] = Integer.MAX_VALUE;
      }
    }
  }

  public static void main (String[] args) {
    String start = "a1";
    String end = "h8";
    KnightPathInChess knightPathInChess = new KnightPathInChess();
    int shortestPath = knightPathInChess.findShortestPath(start, end);
    System.out.println(String.format("Shortest path from %s to %s is %s", start, end, shortestPath));
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
        System.out.print(String.format("%s  ", knightPathInChess.chessBoard[i][j]));
      }
      System.out.println();
    }
  }

  public int findShortestPath(String start, String end) {
    int startI = start.toUpperCase().charAt(0) - 'A';
    int startJ = start.toUpperCase().charAt(1) - '1';
    int endI = end.toUpperCase().charAt(0) - 'A';
    int endJ = end.toUpperCase().charAt(1) - '1';

    chessBoard [startI][startJ] = 0;

    jumpInAllDirections(startI, startJ, 0);

    return chessBoard[endI][endJ];
  }

  private void jumpInAllDirections(int i, int j, int jumps) {
    jumps++;
    jump(i - 2, j + 1, jumps);
    jump(i - 1, j + 2, jumps);
    jump(i + 1, j + 2, jumps);
    jump(i + 2, j + 1, jumps);
    jump(i + 2, j - 1, jumps);
    jump(i + 1, j - 2, jumps);
    jump(i - 1, j - 2, jumps);
    jump(i - 2, j - 1, jumps);
  }

  private void jump(int i, int j, int jumps) {
    if (isJumpValid(i, j) && (chessBoard[i][j] == -1 || chessBoard[i][j] > jumps)) {
      chessBoard[i][j] = jumps;
      jumpInAllDirections(i, j, jumps);
    }
  }

  private boolean isJumpValid(int i, int j) {
    return i >= 0 && i < 8 && j >= 0 && j < 8;
  }
}
