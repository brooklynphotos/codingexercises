# https://www.hackerrank.com/challenges/sum-vs-xor/problem

def sumXor(n):
    s = '{0:b}'.format(n)
    return 1 if n==0 else pow(2, s.count('0'))

if __name__ == '__main__':
    print(sumXor(3),"\n")
    print(sumXor(0),"\n")