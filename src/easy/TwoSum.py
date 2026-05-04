class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # populate dict
        data = {}
        for i in range(len(nums)):
            data[nums[i]] = i

        for i, num in enumerate(nums):
            need = target - num
            if need in data and data[need] is not i:
                return [data[need], i]


if __name__ == "__main__":
    sol = Solution()
    print(sol.twoSum([2,5,5,11], 10))