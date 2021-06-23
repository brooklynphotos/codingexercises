# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
  A.sort()
  prev = 0
  for i in range(len(A)):
    a = A[i]
    if a<1 or a==prev:
      continue
    if a==prev+1:
      prev = a
    else:
      return prev+1
  return prev + 1
