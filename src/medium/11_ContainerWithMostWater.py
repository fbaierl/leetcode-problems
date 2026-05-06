class Solution:
    def maxArea(self, height: List[int]) -> int:
        
        def calculateWater(l, r):
            h = min(height[l], height[r])
            return (r - l) * h 

        res = 0
        l = 0 
        r = len(height) - 1

        while l <= r: 
            curr = calculateWater(l, r)
            res = curr if curr > res else res
            if height[l] > height[r]:
                r = r - 1
            else:
                l = l + 1

        return res

    def calculateWater(self, height: List[int], l, r):
        h = min(height[l], height[r])
        return (r - l) * h 


if __name__ == "__main__":
    sol = Solution()
    print(sol.maxArea([1,8,6,2,5,4,8,3,7]))
    print(sol.maxArea([1,1]))
    # print(sol.maxArea([1,8,6,2,5,4,8,3,7]))              