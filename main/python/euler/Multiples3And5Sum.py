# https://projecteuler.net/problem=1
def sum(upper):
    sum = 0
    for x in range(upper):
        if x % 3 == 0 or x % 5 == 0:
            sum += x
    return sum

if __name__ == '__main__':
    print(sum(1000), "\n")