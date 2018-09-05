package medium
/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */
object CombinationSum {

  def main(args: Array[String]): Unit = {
    val res1 = combinationSum(Array(2,3,6,7), 7)
    val goal1 = List(List(7), List(2,2,3))
    println(res1 == goal1)
    val res2 = combinationSum(Array(2,3,4), 8)
    val goal2 = List(List(2,2,2,2), List(2,3,3), List(3,5))
    println(res2 == goal2)
  }

  val result : List[List[Int]] = List()

  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    // TODO prbly simple backtracking
    throw new NotImplementedError()
  }
}
