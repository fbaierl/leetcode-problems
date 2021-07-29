package medium

import scala.annotation.tailrec

object ZigZagConversion {


  def main(args: Array[String]): Unit = {
    assert(convert("PAYPALISHIRING", 4) == "PINALSIGYAHRPI")
    assert(convert("PAYPALISHIRING", 3) == "PAHNAPLSIIGYIR")
    assert(convert("A", 1) == "A")
  }

  private type CharMatrix = List[List[Char]]
  private val emptyChar = '*'

  def convert(s: String, numRows: Int): String = {
    @tailrec
    def createMatrix(s: String, result: CharMatrix = Nil): CharMatrix = {
      def createStairColumn(c: Char, pos: Int) = (0 until numRows).map(i => if(i == pos) c else emptyChar).toList
      s.toList match {
        case x :: xs =>
          val remaining = xs.mkString
          val moduloIndex = if(numRows <= 1) 0 else result.size % (numRows - 1)
          if(result.isEmpty)
            createMatrix(remaining, List(x :: Nil)) // first waterfall column, first letter
          else if(result.last.size < numRows) // waterfall, that is not full
            createMatrix(remaining, result.take(result.size - 1) :+ (result.last :+ x)) // append to waterfall column
          else if(moduloIndex == 0) // waterfall, that is full
            createMatrix(remaining, result :+ List(x)) // start a new waterfall column
          else
            createMatrix(remaining, result :+ createStairColumn(x, numRows - (moduloIndex + 1))) // create ladder column
        case _ => result
      }
    }

    def tailOption(value: List[Char]) = if(value.isEmpty) None else Some(value.tail)

    def readFromMatrix(remaining: CharMatrix): String =
      if(remaining.exists(_.nonEmpty))
        remaining.flatMap(_.headOption).mkString + readFromMatrix(remaining.flatMap(l => tailOption(l)))
      else
        ""

    readFromMatrix(createMatrix(s)).filter(_ != emptyChar)
  }

}
