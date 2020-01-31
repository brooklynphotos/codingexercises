# https://projecteuler.net/problem=2
def sum(max):
    a = 1
    f = 2
    sum = f # f is even
    while(f<max):
        a,f = f, a+f
        if f%2==0:
            sum += f
    return sum

if __name__ == '__main__':
    print(sum(4000000), "\n")
