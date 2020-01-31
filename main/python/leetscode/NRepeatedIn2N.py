# https://leetcode.com/contest/weekly-contest-116/problems/n-repeated-element-in-size-2n-array/
class Solution:
    def repeatedNTimes(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        visited = set()
        for x in A:
            if x in visited:
                return x
            visited.add(x)
        raise Exception("Shouldn't get here")

if __name__ == '__main__':
    print(Solution().repeatedNTimes([5,1,5,2,5,3,5,4])==5, "\n")