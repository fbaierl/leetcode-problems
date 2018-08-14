/*
https://leetcode.com/problems/first-missing-positive/description/

Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space
 */

object Solution {


  def main(args: Array[String]): Unit = {
    val x1 = firstMissingPositive(Array(1,2,0))
    println ("Should be 3: " + x1)
    val x2 = firstMissingPositive(Array(0))
    println ("Should be 1: " + x2)
    val x3 = firstMissingPositive(Array(4,3,2,1))
    println ("Should be 5: " + x3)
  }


  def firstMissingPositive(nums: Array[Int]): Int = {
    // If the array is empty, the answer is 1
    if(nums.length == 0){
      return 1
    }
    // O(n), in-place
    def eliminateNegatives(xs: Array[Int]): Unit =
    {
      for(i <- xs.indices){
        if(xs(i) <= 0) {
          xs(i) = xs.length + 1
        }
      }
    }
    // O(n), in-place
    def markIndicesWithNegativeNumbers(xs: Array[Int]): Unit = {
      for(i <- xs.indices){
        // since we use negatives to mark an array cell, we need Math.abs here...
        var pointer = Math.abs(xs(i))
        // Now, every time we encounter an Integer value, we will mark the value in the
        // index of the array this value points to with a negative number.
        if(pointer <= xs.length){
          // We can ignore 0 since - according to the examples given - it is not a valid
          // solution, so we shift our pointers one to the left
          pointer = pointer - 1
          if(xs(pointer) > 0){
            xs(pointer) = xs(pointer) * -1
          }
        }
      }
    }
    // Negative entries are irrelevant, so I'll mark them with num.length+1.
    // The solution will be somewhere between 1 and num.length + 1
    // (if num looks like this: 1,...,n-1 then the answer is n).
    eliminateNegatives(nums)
    // Since we cannot transfer the array to another array (constant space condition!),
    // we need a way to 'mark' each index of the input array to show that this index
    // was present - as a value - in the list given.
    // Since we made sure there are only positive values in the array before,
    // I will use negative numbers for that.
    markIndicesWithNegativeNumbers(nums)
    // Lastly, we only need to search for the first index which does not point to
    // a negative number. This index will be the solution.
    for(i <- nums.indices){
      if(nums(i) > 0){
        return i + 1
      }
    }
    // We havent found anything? Then the answer is nums.length + 1 ...
    nums.length + 1
  }
}

