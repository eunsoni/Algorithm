import sys
input = sys.stdin.readline

n = int(input())
A = list(map(int, input().split()))
ans = [0] * n
mystack = []

for i in range(n):
    while mystack and A[mystack[-1]] < A[i]:
        ans[mystack.pop()] = A[i]
    mystack.append(i)

for i in mystack:
    ans[i] = -1

print(' '.join(map(str, ans)))