# https://www.hackerrank.com/challenges/is-fibo/problem
def solve(n):
    a = 1
    b = 1
    while b<=n:
        if b==n:
            return "IsFibo"
        a, b = b, a+b

    return "IsNotFibo"

if __name__ == '__main__':
    print(solve(10)=="IsNotFibo", "\n")
    print(solve(8)=="IsFibo", "\n")
    print(solve(12586269025)=="IsFibo", "\n")