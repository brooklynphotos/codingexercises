# https://www.hackerrank.com/challenges/maxsubarray/problem

def maxSubarray(arr):
    return [max_subarray(arr), max_subsequence(arr)]

def max_subsequence(arr):
    sarr = sorted(arr)
    if(sarr[-1])<=0:
        return sarr[-1]
    sum = 0
    for x in sarr:
        if sum > 0:
            sum += x
        elif x>0:
            sum += x
    return sum

def max_subarray(arr):
    minNum = pow(10, 5) * -1 * pow(10,4)
    dp = [minNum]*len(arr)
    maxSum = minNum
    for j in range(len(arr)):
        dp[j] = max(arr[j] + (0 if j==0 else dp[j-1]), arr[j])
        maxSum = max(maxSum, dp[j])
    return maxSum


def readInput(file):
    with open(file) as f:
        lines = f.readlines()
        for l in lines[2:]:
            arr = list(map(int, l.split()))
            if len(arr)>1:
                print(maxSubarray(arr))

if __name__ == '__main__':
    readInput("/Users/gzhong/projects/codingexercises/data/maxSubarray_input01.txt")
    print(maxSubarray([1, 2, 3, 4]))
    print(maxSubarray([2, -1, 2, 3, 4, -5]))
    print(maxSubarray([-2, -3, -1, -4, -6]))
