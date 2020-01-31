# https://projecteuler.net/problem=14
import time

def longestCollatz(n):
    maxLength = 0
    maxId = -1
    for x in range(n,0,-1):
        l = findCollatzLength(x)
        if l>maxLength:
            maxLength = l
            maxId = x
    return maxId

def findCollatzLength(x):
    count = 0
    while x>1:
        x = x//2 if x%2==0 else 3*x + 1
        count += 1
    return count

if __name__ == '__main__':
    start = time.time()
    print(longestCollatz(1000000),"\n")
    print(time.time() - start, "\n")