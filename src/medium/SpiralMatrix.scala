package medium

/**
  * https://leetcode.com/problems/spiral-matrix/
  *
  * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
  *
  * Example 1:
  *
  * Input:
  * [
  * [ 1, 2, 3 ],
  * [ 4, 5, 6 ],
  * [ 7, 8, 9 ]
  * ]
  * Output: [1,2,3,6,9,8,7,4,5]
  * Example 2:
  *
  * Input:
  * [
  * [1, 2, 3, 4],
  * [5, 6, 7, 8],
  * [9,10,11,12]
  * ]
  * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
  */
object SpiralMatrix {

  def main(args: Array[String]): Unit = {
    val sampleInput = Array(Array(1,2,3,4),Array(5,6,7,8),Array(9,10,11,12),Array(13,14,15,16))
    println(spiralOrder(sampleInput))
  }

  def cutFirstRow(m: List[List[Int]]): Option[(List[Int], List[List[Int]])] =
    m match {
      case x :: xs => Some((x, xs))
      case Nil => None
    }

  def cutLastRow(m: List[List[Int]]): Option[(List[Int], List[List[Int]])] =
    m.reverse match {
      case x :: xs => Some(x.reverse, xs.reverse)
      case Nil => None
    }

  def cutFirstColumn(m: List[List[Int]]): Option[(List[Int], List[List[Int]])] =
    if(m.headOption.exists(_.nonEmpty))
      Some(m.map(_.head).reverse, m.map(_.tail))
    else
      None

  def cutLastColumn(m: List[List[Int]]): Option[(List[Int], List[List[Int]])] =
    if(m.headOption.exists(_.nonEmpty))
      Some(m.map(column => column.last), m.map(_.dropRight(1)))
    else
      None

  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    var m = matrix.toList.map(_.toList)
    var result: List[Int] = Nil
    val operations = cutFirstRow _ :: cutLastColumn _ :: cutLastRow _ :: cutFirstColumn _ :: Nil
    while(m.nonEmpty){
      operations.foreach { operation =>
        operation(m) match {
          case Some((x, y)) =>
            result ++= x
            m = y
          case _ => ()
        }
      }
    }
    result
  }
}