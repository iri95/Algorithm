N, M = map(int,input().split())
a = list(map(int,input().split()))
result = []
for i in range(N-2) :
    for j in range(i+1, N-1) :
        for k in range(j+1, N) :
            result.append(a[i] + a[j] + a[k])

min_M = result[0]
sub = 300000
for b in result :
    if abs(M - b) < sub and M - b >= 0:
        min_M = b
        sub = abs(M - b)
print(min_M)
