package medium

object NumberOfIslands {
    def main(args: Array[String]): Unit = {
        val input1 = Array(
            Array('1','1','1','1','0'),
            Array('1','1','0','1','0'),
            Array('1','1','0','0','0'),
            Array('0','0','0','0','0')
        )
        println("Should be 1: " + numIslands(input1))
        val input2 = Array(
            Array('1','1','0','0','0'),
            Array('1','1','0','0','0'),
            Array('0','0','1','0','0'),
            Array('0','0','0','1','1')
        )
        println("Should be 3: " + numIslands(input2))
    }

    def numIslands(grid: Array[Array[Char]]): Int = {
        // cells we have already visited, only stores '1' cells
        var used = List()
        // number of found islands
        var result = 0

        // TODO
        // for each cell
        // if '1' & not in used:
        //   -> BFS with queue to find adjacent '1's
        //   -> add every visited '1' cell to used
        //   -> result++

        result
    }
}
