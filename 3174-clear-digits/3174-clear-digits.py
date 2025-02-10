class Solution:
    def clearDigits(self, s: str) -> str:
        ls=[i for i in s]
        for _ in range(50):
            for i in range(1,len(ls)):
                if ls[i].isdigit():
                    ls.pop(i)
                    ls.pop(i-1)
                    break
        return "".join(ls)
                    