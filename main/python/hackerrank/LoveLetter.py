# https://www.hackerrank.com/challenges/the-love-letter-mystery/problem
def theLoveLetterMystery(s):
    c = 0
    for i in range(int(len(s) / 2)):
        c += abs(ord(s[i]) - ord(s[len(s) - i - 1]))
    return c

if __name__ == '__main__':
    print(theLoveLetterMystery("abcd"), "\n")