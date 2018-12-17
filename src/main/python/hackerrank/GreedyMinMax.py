# https://www.hackerrank.com/challenges/angry-children/problem
def maxMin(k, arr):
    arr.sort()
    currStart = 0
    for i in range(len(arr) - k + 1):
        unfairVal = unfair(arr,i,k)
        if unfairVal < unfair(arr,currStart, k):
            currStart = i
        if unfairVal==0:
            return unfairVal

    return unfair(arr,currStart, k)

def unfair(arr, i, k):
    return arr[i+k-1] - arr[i]

if __name__ == '__main__':
    print(maxMin(3, [10,100,300,200,1000,20,30])==20, "\n")
    print(maxMin(2, [1,2,1,2,1])==0, "\n")
    print(maxMin(5, [1,2,3,4,5])==4, "\n")
    print(maxMin(4, [1,200,3,4,10,20,30,40,100,2])==3, "\n")
    print(maxMin(3, [100, 200, 300, 350, 400, 401, 402])==2, "\n")