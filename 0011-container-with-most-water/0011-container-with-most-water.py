class Solution:
    def maxArea(self, height: List[int]) -> int:
        m=0
        left,right=0,len(height)-1
        while left<right:
            l=right-left
            h=min(height[left],height[right])
            m=max(m,l*h)
            if height[left]<height[right]:
                left+=1
            else:
                right-=1
        return m