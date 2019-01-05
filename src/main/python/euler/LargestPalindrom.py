# https://projecteuler.net/problem=4
import time

def timeit(method):
    def timed(*args, **kw):
        ts = time.time()
        result = method(*args, **kw)
        te = time.time()
        if 'log_time' in kw:
            name = kw.get('log_name', method.__name__.upper())
            kw['log_time'][name] = int((te - ts) * 1000)
        else:
            print('%r  %2.2f ms' % \
                  (method.__name__, (te - ts) * 1000)
                  )
        return result
    return timed

@timeit
def largestPalin(digits):
    def get_range():
        return reversed(range(pow(10, digits - 1), pow(10, digits)))
    maxP = 0
    for a in get_range():
        for b in get_range():
            x = a * b
            if isPalinCached(x):
                maxP = max(maxP, x)
    return maxP

palins = set()
nonpalins = set()
def isPalinCached(x):
    if x in palins:
        return True
    if x in nonpalins:
        return False
    r = isPalin(x)
    if r:
        palins.add(x)
    else:
        nonpalins.add(x)
def isPalin(x):
    xs = str(x)
    for i in range(int(len(xs)/2)):
        if xs[i] != xs[len(xs) - i -1]:
            return False
    return True

if __name__ == '__main__':
    print(isPalin(12321),"\n")
    print(isPalin(123321),"\n")
    print(isPalin(123421),"\n")
    print(largestPalin(3),"\n")
    print(largestPalin(2),"\n")

