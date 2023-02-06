N = int(input())
a = list(map(int,input().split()))
max_a = max(a)
for i in range(N) :
    a[i] = a[i] / max_a * 100
print(sum(a)/N)