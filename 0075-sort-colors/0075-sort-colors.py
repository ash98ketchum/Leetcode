class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        count_0, count_1, count_2 = nums.count(0), nums.count(1), nums.count(2)
        
        for i in range(count_0):
            nums[i] = 0
        
        for i in range(count_0, count_0 + count_1):
            nums[i] = 1

        for i in range(count_0 + count_1, count_0 + count_1 + count_2):
            nums[i] = 2