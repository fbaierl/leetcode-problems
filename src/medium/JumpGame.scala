import util.control.Breaks._

object JumpGame {    
    // w/o recursion this is solvable in O(n) time; O(1) space using DP
    def canJump(nums: Array[Int]): Boolean = {
        // the left-most index of the array that can lead us to the end
        var leftMost: Int = nums.length - 1
        // starting point is one left to the final goal
        for(i <- nums.length - 2 to 0 by -1){
            // check for each jumping distance if we can reach the goal
            // we can break on success since we only need one way
            breakable{
                for(jumpingDist <- nums(i) to 0 by -1){
                    if(jumpingDist == leftMost - i){
                        leftMost = i
                        break
                    }
                }                
            }

        }
        leftMost == 0
    }
}
