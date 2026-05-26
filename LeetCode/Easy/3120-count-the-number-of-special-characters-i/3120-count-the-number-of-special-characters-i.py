class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        count=0
        s=set()
        for i in word:
            lcase=i.lower()
            
            if lcase !=i.upper():
                if lcase not in s:
                    if lcase !=i:
                        if i.lower() in word:
                            count+=1
                            s.add(lcase)
                        else:
                            s.add(lcase)
        return count