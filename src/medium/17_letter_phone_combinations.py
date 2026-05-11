class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        
        # Edge case: return empty list if input is empty
        if not digits:
            return []
        
        # Digit to letter mapping
        phone_map = {
            "2": "abc", "3": "def", "4": "ghi", "5": "jkl",
            "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"
        }

        res = []


        def backtrack(index, path):
            # Base Case: If the path is the same length as digits, we're done
            if len(path) == len(digits):
                res.append(path)
                return
            
            # Recursive Step: Get letters for current digit and iterate
            possible_letters = phone_map[digits[index]]
            for letter in possible_letters:
                backtrack(index + 1, path + letter)

        backtrack(0, "")
        return res    



if __name__ == "__main__":
    sol = Solution()
    print(sol.letterCombinations("23"))       # ["ad","ae","af","bd","be","bf","cd","ce","cf"] 