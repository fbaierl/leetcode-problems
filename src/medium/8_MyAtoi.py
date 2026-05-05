class Solution:
    def myAtoi(self, s: str) -> int:
        
        # remove whitespace
        s = s.lstrip()

        # return if empty
        if not s:
            return 0

        # check for signedness
        negative = True if s[0] == "-" else False

        # remove signedness
        if s[0] == "+": 
            s = s.removeprefix("+")
        elif s[0] == "-":
            s = s.removeprefix("-")

        # remove trailing 0s
        s = s.lstrip("0")

        # take digits
        digits = ""
        for char in s: 
            if char.isdigit():
                digits += char
            else: 
                break

        # convert & round
        try: 
            res = int(digits) * (-1 if negative else 1)

            if res > 2 ** 31 - 1: 
                return 2 ** 31 - 1
            if res < -2 ** 31:
                return -2 ** 31

            return res                   
        except:
            return 0


if __name__ == "__main__":
    sol = Solution()
    print(sol.myAtoi(""))            