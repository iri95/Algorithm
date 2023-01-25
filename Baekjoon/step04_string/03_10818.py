N = int(input())
A = list(map(int,input().split()))
A_max = A[0]
A_min = A[0]
for i in A :
    if A_max < i :
        A_max = i
    if A_min > i :
        A_min = i
print(f'{A_min} {A_max}')