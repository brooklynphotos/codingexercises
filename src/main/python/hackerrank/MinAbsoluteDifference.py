# https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
def minimumAbsoluteDifference(arr):
    arr.sort()
    currIndex = 0
    for i in range(len(arr)-1):
        if abs(arr[i+1]-arr[i])<abs(arr[currIndex+1] - arr[currIndex]):
            currIndex = i
    return abs(arr[currIndex+1] - arr[currIndex])

def to_arr(str):
    return list(map(int, str.split()))


if __name__ == '__main__':
    print(minimumAbsoluteDifference(to_arr("1 -3 71 68 17"))==3, "\n")
    print(minimumAbsoluteDifference(to_arr("-59 -36 -13 1 -53 -92 -2 -96 -54 75"))==1, "\n")
