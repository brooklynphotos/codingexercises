# https://projecteuler.net/problem=3
primes = []

def largestPrimeFactor(n):
    def isPrime(j):
        for p in primes:
            if j % p ==0:
                return False
        return True
    p = 2
    for x in range(p, n):
        if isPrime(x):
            primes.append(x)
            if n % x == 0:
                return largestPrimeFactor(int(n / x))
    return n

if __name__ == '__main__':
    print(largestPrimeFactor(13195)==29, "\n")
    print(largestPrimeFactor(600851475143), "\n")
