package medium

/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by
the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight
neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is
created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur
simultaneously.

Example:

Input:
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output:
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
Follow up:

Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells
first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause
problems when the active area encroaches the border of the array. How would you address these problems?
 */

object GameOfLife {

  def gameOfLife(board: Array[Array[Int]]): Unit = {
    /*
     * To solve this in-place we will solve this in 2 consecutive steps.
     * 1. for each array we will calculate its new value, but instead of writing in this value, we write:
     *    o 1, if the value was 1 before and stays 1
     *    o 0, if the value was 0 and stays 0
     *    o 2, if the value was 1 and will be 0
     *    o 3, if the value was 0 and will be 1
     *    Using this method, we can calculate all fields w/o any added space
     * 2. Transform the array so that for each cell:
     *    o 1 -> 1
     *    o 0 -> 0
     *    o 2 -> 0
     *    o 3 -> 1
     */

    def isAlive(board: Array[Array[Int]], i: Int, j: Int): Boolean = {
      board(i)(j) match {
        case 1 | 2 => true
        case _     => false
      }
    }

    /**
      * Counts the life neighbors of the cell at (i,j)
      * @param board the world
      * @param i i-index
      * @param j j-index
      * @return number of life neighbors of cell (i,j)
      */
    def countNeighbors(board: Array[Array[Int]], i: Int, j: Int): Int = {
      var result = 0
      if(i-1 >= 0){
        if(isAlive(board, i-1, j)){
          result += 1
        }
        if(j-1 >= 0 && isAlive(board, i-1, j-1)){
            result += 1
        }
        if(j+1 < board(i).length && isAlive(board, i-1, j+1)){
            result += 1
        }
      }
      if(i+1 < board.length){
        if(isAlive(board, i+1, j)){
          result += 1
        }
        if(j-1 >= 0 && isAlive(board, i+1, j-1)){
            result += 1
        }
        if(j+1 < board(i).length && isAlive(board, i+1, j+1)){
          result += 1
        }
      }
      if(j-1 >= 0 && isAlive(board, i, j-1)){
        result += 1
      }
      if(j+1 < board(i).length && isAlive(board, i, j+1)){
        result += 1
      }
      result
    }

    def calculateValuesInPlace (board: Array[Array[Int]]): Array[Array[Int]] = {
      for(i <- board.indices){
        for(j <- board(i).indices){
          board(i)(j) = board(i)(j) match {
            case 0 =>
              // cell is dead
              countNeighbors(board, i, j) match {
                case 3 => 3  // reproduction
                case _ => 0  // nothing happens
              }
            case _ =>
              // is is alive
              countNeighbors(board, i, j) match {
                case x if x < 2           => 2 // under-population, dies
                case x if x >= 2 & x <= 3 => 1 // lives
                case _                    => 2 // over-population, dies
              }
          }
        }
      }
      board
    }

    def updateValues(board: Array[Array[Int]]) : Array[Array[Int]] = {
      for(i <- board.indices) {
        for (j <- board(i).indices) {
          board(i)(j) = board(i)(j) match {
            case 1 | 3 => 1
            case _     => 0
          }
        }
      }
      board
    }

    updateValues(calculateValuesInPlace(board))
  }
}
