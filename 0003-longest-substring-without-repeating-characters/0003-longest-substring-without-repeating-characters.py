class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        longest=''
        est=''
        for i in s:
            if i not in est:
                est += i
                if len(est) > len(longest):
                    longest = est
            else:
                est = est[est.index(i) + 1:] + i
        self=len(longest)
        return self