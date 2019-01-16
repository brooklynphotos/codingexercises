# https://www.hackerrank.com/challenges/sansa-and-xor/problem
def sansaXor(arr):
    return 0 if len(arr) % 2 ==0 else xorOdds(arr)

def xorOdds(arr):
    res = 0
    for i in range(0,len(arr),2):
        res ^= arr[i]
    return res

if __name__ == '__main__':
    print(sansaXor([98,74,12])==110,"\n")
    print(sansaXor([50,13,2])==48,"\n")
    print(sansaXor([4,5,7,5])==0,"\n")