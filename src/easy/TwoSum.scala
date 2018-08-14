package easy
/*
https://leetcode.com/problems/two-sum/description/

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.
*/

import util.control.Breaks._

object TwoSum {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        var result : Array[Int] = null
        for(i <- 0 to nums.size - 1){
            for(j <- 0 to nums.size - 1){
                breakable {
                    if(i == j) 
                        break
                    if(nums(i) + nums(j) == target)
                        result = Array(i, j)
                }
            }
        }
        result
    }
}   
