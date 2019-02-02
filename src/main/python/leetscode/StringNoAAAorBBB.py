# https://leetcode.com/contest/weekly-contest-121/problems/string-without-aaa-or-bbb/

class StringNoAAAorBBB:
    def strWithout3a3b(self, A, B):
        """
        :type A: int
        :type B: int
        :rtype: str
        """
        l = max(A, B)
        s = min(A, B)
        lc,sc = ('a','b') if l==A else ('b','a')
        r = [lc+sc] * s
        diff = l - s
        if diff >0:
            r.append(lc)
            diff -= 1
        for i in range(len(r)):
            if diff<=0:
                break
            r[i] = lc + r[i]
            diff -= 1
        return ''.join(r)

if __name__ == '__main__':
    print(StringNoAAAorBBB().strWithout3a3b(1, 2), "\n")
    print(StringNoAAAorBBB().strWithout3a3b(4, 1), "\n")
    print(StringNoAAAorBBB().strWithout3a3b(5, 3), "\n")
    print(StringNoAAAorBBB().strWithout3a3b(5, 2), "\n")
    print(StringNoAAAorBBB().strWithout3a3b(4, 7), "\n")
    print(StringNoAAAorBBB().strWithout3a3b(1, 3), "\n")