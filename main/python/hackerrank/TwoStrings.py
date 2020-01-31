# https://www.hackerrank.com/challenges/two-strings/problem
def twoStrings(s1, s2):
    for c in s1:
        if c in s2:
            return True

    return False

if __name__ == '__main__':
    print(twoStrings("ab", "b"), "\n")