class Solution:
    def countAndSay(self, n: int) -> str:
        number=['1']
        for i in range(1, n):
            a = number[-1]
            count = 1
            b = ''
            for j in range(1, len(a)):
                if a[j] == a[j - 1]:
                    count += 1
                else:
                    b += str(count) + a[j - 1]
                    count = 1
            b += str(count) + a[-1]
            number.append(b)
        return number[-1]