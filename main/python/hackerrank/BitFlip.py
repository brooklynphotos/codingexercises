def flip(n):
    big = pow(2,32) - 1
    return big ^ n

if __name__ == '__main__':
    print(flip(2147483647), "\n")
    print(flip(1), "\n")
    print(flip(0), "\n")