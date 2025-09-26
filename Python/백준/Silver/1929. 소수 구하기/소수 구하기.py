import math

m, n= map(int, input().split())
A=[True]*(n+1)
A[0] = A[1] = False

for i in range(2, int(math.sqrt(n)) + 1):
    if A[i]:
        for j in range( i*i, n+1, i):
            A[j] = False

for i in range(m, n + 1):
    if A[i]:
        print(i)