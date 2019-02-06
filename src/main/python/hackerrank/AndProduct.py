# https://www.hackerrank.com/challenges/and-product

def andProductStr(a, b):
    x = '{0:b}'.format(a)
    y = '{0:b}'.format(b)
    if len(x) != len(y):
        return 0
    end = False
    output = ''
    for i in range(len(x)):
        if end:
            output += '0'
        else:
            if x[i]==y[i]:
                output += x[i]
            else:
                end = True
                output += '0'
    return int(output, 2)

def andProductShift(a, b):
    i = 0
    while(a != b):
        a,b,i = a>>1,b>>1,i+1
    return a<<i

def andProduct(a,b):
    return andProductStr(a,b)
    # return andProductShift(a,b)

if __name__ == '__main__':
    print(andProduct(12, 15), "\n")
    print(andProduct(2, 3), "\n")
    print(andProduct(8, 13), "\n")
    print(andProduct(17, 23), "\n")
    print(andProduct(11, 15), "\n")
    print(andProductStr(2793505060, 3037233937), "\n")
    print(andProductShift(2793505060, 3037233937), "\n")
    if True:
        import random
        for x in range(1000):
            a = random.randint(0,pow(2,32))
            b = random.randint(0,pow(2,32))
            if andProductShift(a, b) != andProductStr(a, b):
                print(x,"[",a,':',b,"]\n")
                break
        print("Matched!\n")