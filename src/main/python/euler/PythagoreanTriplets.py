# https://projecteuler.net/problem=9
def pyth(sum):
    for a in range(1,int(sum/(pow(2,0.5)+1))):
        b = (0.5*pow(sum,2) - sum*a)/(sum - a)
        if isInt(b):
            c = sum - a - b
            return a * b * c
    raise Exception("Doesn't exist")

def isInt(n):
    return n==int(n)

if __name__ == '__main__':
    print(pyth(1000), "\n")