class Solution:
    def isValid(self, word: str) -> bool:
        vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}
        if len(word) < 3:
            return False

        v = False
        c = False

        for i in word:
            if i.isalpha() or i.isdigit():
                if i in vowels:
                    v = True
                elif i.isalpha():
                    c = True
            else:
                return False

        return c and v