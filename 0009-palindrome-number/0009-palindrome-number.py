class Solution:
    def isPalindrome(self, x: int) -> bool:
        x=str(x)
        y=x
        ls=[]
        for i in x:
            ls.append(i)
        ls.reverse()
        x=''
        for i in ls:
            x=x+i
        if x==y:
            return True
        else:
            return False