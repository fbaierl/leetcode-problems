package hard

import hard.FirstMissingPositive.firstMissingPositive

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
6 units of rain water (blue section) are being trapped.

Example:
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

 */

object TrappingRainWater {

  def main(args: Array[String]): Unit = {
    println("Should be 6: " + trap(Array(0,1,0,2,1,0,1,3,2,1,2,1)))
    println("Should be 0: " + trap(Array(0,0,0,1,1,1,0,0)))
    println("Should be 1: " + trap(Array(0,1,1,2,1,2,2,2,2)))
    println("Should be 3: " + trap(Array(1,0,0,0,1)))

    /*
     * MoooM
     * MoMoM
     */
    println("Should be 5: " + trap(Array(2,0,1,0,2)))
  }

  def trap(height: Array[Int]): Int = {
    0
  }
}
