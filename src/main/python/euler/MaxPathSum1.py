# https://projecteuler.net/problem=18

def maxSum(pyramid):
    # replicate structure of pyramid
    dp = []
    for i in range(len(pyramid)):
        if i==len(pyramid) -1:
            dp.append(pyramid[i][:])
        else:
            dp.append([None]*len(pyramid[i]))
    # loop through all the pyramid levels again except for the bottom one since we already have values for that row
    for i in range(len(pyramid)-2, -1, -1):
        arr = pyramid[i]
        dpi = dp[i]
        prevDpi = dp[i+1]
        for j in range(len(arr)):
            dpi[j] = arr[j] + max(prevDpi[j],prevDpi[j+1])
    return dp[0][0]

def readPyramid(filePath):
    with open(filePath) as f:
        return [list(map(int, l.strip().split())) for l in f]

if __name__ == '__main__':
    print(maxSum([[3],[7,4],[2,4,6],[8,5,9,3]]),"\n")
    print(maxSum(readPyramid('data/triangle1.txt')),"\n")
    print(maxSum(readPyramid('data/triangle2.txt')),"\n")
