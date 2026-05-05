class Solution:
    def lengthOfLongestSubstringBruteForce(self, s: str) -> int:
        
        seen_set = set()
        current_length = 0
        longest = 0


        for i in range(len(s)):   
             # reset before next i calculation
            seen_set = set()
            current_length = 0

            for j in range(i, len(s)):
                # check if we encountered this before
                if s[j] in seen_set:
                    seen_set = set()
                    break # break out to next i
                
                current_length = current_length + 1
                if current_length > longest:
                        longest = current_length
                seen_set.add(s[j])

        return longest


    def lengthOfLongestSubstring(self, s: str) -> int:    

        substringWithIndices = {}
        l = 0
        longest = 0 

        for r in range(len(s)):

            if s[r] in substringWithIndices and substringWithIndices[s[r]] >= l:
                # move l
                l = substringWithIndices[s[r]] + 1
            
            substringWithIndices[s[r]] = r
            longest = max(longest, r - l + 1)

        return longest



if __name__ == "__main__":
    sol = Solution()
    print(sol.lengthOfLongestSubstring("abaaac"))