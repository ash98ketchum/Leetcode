class Solution:
    def countBadPairs(self, nums: List[int]) -> int:
        count=defaultdict(int)
        tot=0
        good=0
        for i in range(len(nums)):
            tot+=i
            good+=count[nums[i]-i]
            count[nums[i]-i]+=1
        return tot-good