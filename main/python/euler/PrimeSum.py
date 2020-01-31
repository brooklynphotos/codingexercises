# https://projecteuler.net/problem=10
import math
def primeSum(upperLimit):
    # Eratosthenes
    nums = [True] * (upperLimit + 1)
    nums[1] = False
    # start with 2
    for x in range(2,int(math.sqrt(upperLimit))+1):
        for j in range(pow(x,2), upperLimit,x):
            nums[j] = False
    sum = 0
    for x in range(0,upperLimit):
        if nums[x]==True:
            sum += x
    return sum

if __name__ == '__main__':
    print(primeSum(10)==17,"\n")
    print(primeSum(2000000),"\n")