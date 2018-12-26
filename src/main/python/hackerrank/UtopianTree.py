#https://www.hackerrank.com/challenges/utopian-tree/problem
import math
def utopianTree(n):
    return pow(2, math.ceil(n/2)+1) - (1 if n % 2==0 else 2)

if __name__ == '__main__':
    print(utopianTree(4)==7,"\n")
    print(utopianTree(5)==14,"\n")
    print(utopianTree(0)==1,"\n")