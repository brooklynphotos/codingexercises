# https://projecteuler.net/problem=7
def prime(nth):
    primes = []
    current = 2
    while len(primes) <nth:
        if isPrime(primes,current):
           primes.append(current)
        current += 1
    return primes[len(primes)-1]

def isPrime(primes, x):
    for p in primes:
        if x % p == 0:
            return False
    return True

if __name__ == '__main__':
    print(prime(6)==13,"\n")
    print(prime(10001),"\n")