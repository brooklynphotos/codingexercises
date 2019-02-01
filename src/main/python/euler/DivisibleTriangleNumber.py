# https://projecteuler.net/problem=12
from math import sqrt

def countFactors(n):
    count = 0
    for x in range(1, int(sqrt(n))):
        if n % x == 0:
            count += 1
            if x*x != n:
                count += 1

    return count

def largestTriangleNumber(minFactorCount):
    t, lastInt, tCount = 1, 1, 1
    while(tCount<minFactorCount):
        lastInt += 1
        t = t + lastInt
        tCount = countFactors(t)
    return t

if __name__ == '__main__':
    print(largestTriangleNumber(5),"\n")
    print(largestTriangleNumber(500),"\n")