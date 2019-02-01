# https://projecteuler.net/problem=13

def add(numberStrs, headCount):
    size = len(numberStrs[0])
    res = ""
    carry = 0
    for i in range(size - 1, -1, -1):
        digitSum = 0
        for ns in numberStrs:
            digitSum += int(ns[i])
        digitSum += carry # add the carry from previous time
        carry = digitSum // 10
        digit = digitSum % 10
        res = str(digit) + res
    if carry > 0:
        res = str(carry) + res
    return res[:headCount]

def readInput():
    with open("data/largeSums.txt") as f:
        content = f.readlines()
    return [l.strip() for l in content]

if __name__ == '__main__':
    print(add(["123","456"], 2), "\n")
    print(add(["999","999"], 4), "\n")
    print(add(readInput(), 10), "\n")
