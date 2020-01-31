# https://www.hackerrank.com/challenges/the-power-sum/problem

def powerSum(X, N, candidate):
    candidateRes = pow(candidate, N)
    if candidateRes < X:
        return powerSum(X, N, candidate+1) + powerSum(X - candidateRes, N, candidate+1)
    if candidateRes==X:
        return 1
    return 0

if __name__ == '__main__':
    print(powerSum(100,2,1))