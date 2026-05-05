class Solution:
    def reverse(self, x: int) -> int:
        
        # Define the 32-bit signed integer limits
        MIN_INT = -2**31
        MAX_INT = 2**31 - 1

        asString = str(x)
        reversed = asString[::-1]
        if "-" in reversed:
            reversed = reversed.replace("-", "")
            res = int(reversed) * -1
        else: 
            res = int(reversed)

        # Check for overflow
        if res < MIN_INT or res > MAX_INT:
            return 0

        return res  