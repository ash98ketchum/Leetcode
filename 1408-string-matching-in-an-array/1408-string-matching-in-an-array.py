class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        lst=[]
        for i in range(len(words)):
            for j in range(len(words)):
                if(i!=j):
                    if(words[j] in words[i] and words[j] not in lst):
                        lst.append(words[j])
        return lst
                        
                