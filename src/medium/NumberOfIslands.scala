package medium

import scala.collection.mutable

/*
https://leetcode.com/problems/number-of-islands/description/

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input:
11110
11010
11000
00000
Output: 1

Example 2:
Input:
11000
11000
00100
00011
Output: 3
 */

object NumberOfIslands {
    def main(args: Array[String]): Unit = {
        val input1 = Array(
            Array('1','1','1','1','0'),
            Array('1','1','0','1','0'),
            Array('1','1','0','0','0'),
            Array('0','0','0','0','0'))
        println("Should be 1: " + numIslands(input1))
        val input2 = Array(
            Array('1','1','0','0','0'),
            Array('1','1','0','0','0'),
            Array('0','0','1','0','0'),
            Array('0','0','0','1','1'))
        println("Should be 3: " + numIslands(input2))
        val input3 = Array(
            Array('0','0','0','0','0'),
            Array('0','0','0','0','0'),
            Array('0','0','0','0','0'),
            Array('0','0','0','0','0'))
        println("Should be 0: " + numIslands(input3))
        val input4 = Array(
            Array('1','1','1','1','1'),
            Array('1','1','1','1','1'),
            Array('1','1','1','1','1'),
            Array('1','1','1','1','1'))
        println("Should be 1: " + numIslands(input4))
    }

    /**
      * Starts at location and discovers the island defined in grid
      * @param grid the island
      * @param startingPoint the starting point to discover from
      * @return the visited locations
      */
    def discoverIsland(grid: Array[Array[Char]], startingPoint: (Int, Int)) : List[(Int, Int)] = {
        var used: List[(Int, Int)] = List()
        val queue = new mutable.Queue[(Int, Int)]
        val xLimit = grid(0).length - 1
        val yLimit = grid.length - 1
        def enqueue(point: (Int, Int)) : Unit = {
            queue.enqueue(point)
            used = used.::(point)
        }
        enqueue(startingPoint)
        while(queue.nonEmpty){
            // look around
            val loc = queue.dequeue()
            // go up
            if(loc._1 > 0 &&
              grid(loc._1 - 1)(loc._2) == '1' &&
              !used.contains((loc._1 - 1, loc._2))){
                enqueue((loc._1 - 1, loc._2))
            }
            // go down
            if(loc._1 < yLimit &&
              grid(loc._1 + 1)(loc._2) == '1' &&
              !used.contains((loc._1 + 1, loc._2))){
                enqueue((loc._1 + 1, loc._2))
            }
            // go left
            if(loc._2 > 0 &&
              grid(loc._1)(loc._2 - 1) == '1' &&
              !used.contains((loc._1, loc._2 - 1))){
                enqueue((loc._1, loc._2 - 1))
            }
            // go right
            if(loc._2 < xLimit
              && grid(loc._1)(loc._2 + 1) == '1' &&
              !used.contains((loc._1, loc._2 + 1))){
                enqueue((loc._1, loc._2 + 1))
            }
        }
        used
    }

    def numIslands(grid: Array[Array[Char]]): Int = {
        // cells we have already visited, only stores '1' cells
        var used: List[(Int, Int)] = List()
        // number of found islands
        var result = 0
        // some edge cases
        if(grid.isEmpty || grid(0).isEmpty){
            return 0
        }
        for(i <- grid.indices){
            for(j <- grid(0).indices){
                // if this is an island we have never visited, we go explore it
                if(grid(i)(j) == '1' && !used.contains((i,j))){
                    used = used ::: discoverIsland(grid, (i,j))
                    result += 1
                }
            }
        }
        result
    }
}
