# https://www.hackerrank.com/challenges/cipher

from functools import reduce

def cipher(k, s):
    n = len(s) + 1 - k
    bits = [int(x) for x in s][:n]
    decrypted = [None] * n
    decrypted[0] = bits[0] # always in plain text
    for i in range(1,n):
        decrypted[i] = xorAll(bits[i],decrypted,max(0,i-k+1),i)
    return reduce(lambda resStr,x: resStr + str(x),decrypted, "")

def xorAll(initializer, others, start, upTo):
    res = initializer
    for i in range(start, upTo):
        res ^= others[i]
    return res

if __name__ == '__main__':
    print(cipher(4, "1110100110"),"\n")
    print(cipher(2, "1110001"),"\n")
    print(cipher(3, "1110011011"),"\n")