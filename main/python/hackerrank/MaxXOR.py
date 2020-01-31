#https://www.hackerrank.com/challenges/maximizing-xor/problem

def maximizingXor(l, r):
    maxXor = 0
    for a in range(l, r+1):
        for b in range(l, r+1):
            maxXor = max(maxXor, a ^ b)
    return maxXor

if __name__ == '__main__':
    print(maximizingXor(10, 15)==7,"\n")
    print(maximizingXor(11, 100)==127,"\n")