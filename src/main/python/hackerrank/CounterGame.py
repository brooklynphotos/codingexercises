# https://www.hackerrank.com/challenges/counter-game/problem
import re

def counterGame(n):
    p = ['Louise','Richard']
    z = re.compile('.*1(0+$)')
    b = "{0:0b}".format(n)
    ones = b.count('1')
    zeros = z.findall(b)
    count = ones + len(zeros[0]) if len(zeros)==1 else ones
    return p[count % 2]

if __name__ == '__main__':
    print(counterGame(6)=='Richard',"\n")
    print(counterGame(1)=='Richard',"\n")
    print(counterGame(132)=='Louise',"\n")