# https://www.hackerrank.com/challenges/cipher

from functools import reduce

def cipher(k, s):
    n = len(s) + 1 - k
    decrypted = [None] * n
    decrypted[0] = int(s[0])
    for i in range(1,n):
        decrypted[i] = int(s[i]) ^ int(s[i-1])
        if i>=k:
            decrypted[i] ^= decrypted[i-k]
    return reduce(lambda resStr,x: resStr + str(x),decrypted, "")

if __name__ == '__main__':
    print(cipher(4, "1110100110")=="1001010","\n")
    print(cipher(2, "1110001")=="101111","\n")
    print(cipher(3, "1110011011")=="10000101","\n")