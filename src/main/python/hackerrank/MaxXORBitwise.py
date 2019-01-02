#https://www.hackerrank.com/challenges/maximizing-xor/problem

# based on RodneyShag's Java solution on the forum
def maximizingXor(l, r):
    # most significant bit difference is the first bit in the xor result
    xorbin = '{0:b}'.format(l ^ r)
    # 2^n - 1
    maxXor = int('1'+('0'*len(xorbin)),2) - 1
    return maxXor

if __name__ == '__main__':
    print(maximizingXor(10, 15)==7,"\n")
    print(maximizingXor(11, 100)==127,"\n")