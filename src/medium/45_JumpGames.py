class Solution:
    def jump(self, nums: List[int]) -> int:
        pos = 0
        jumps = 0

        while pos < len(nums) - 1:
            reach = nums[pos]
            possibilities = []
            # care for 0
            for i in range(pos + 1, min(pos + reach + 1, len(nums))):
                possibilities.append((i, nums[i]))
            # jump 1
            jumps += 1
            if len(possibilities) == 0:
                break
            chosen = max(possibilities, 
                        key=lambda item: (min(item[0] + item[1], len(nums) - 1), item[0])) # max, of index + new reach; if equal, jump as far as possible; cap at end
            pos = chosen[0]

        return jumps

if __name__ == "__main__":
    sol = Solution()
    print(sol.jump([2,3,1]))
    print(sol.jump([3,2,1]))
    print(sol.jump([2,3,1,1,4]))
    print(sol.jump([2,1]))