def solution(S, C):
  '''
  S: max 100_000 chars
  C: up to 5 characters
  At least two rows
  Each row has same number of columns
  No newline at the end
  '''
  rows = S.split("\n")
  headers = rows[0].split(',')
  cidx = headers.index(C)
  max_val = -10000 # smaller than the smallest possible value of -9,999
  for ridx in range(1, len(rows)):
    v = rows[ridx].split(',')[cidx] # guaranteed every row has the same number of columns
    max_val = max(int(v), max_val)

  return max_val

  