N = int(input())
for i in range(N) :
    a, b = input().split()
    a = int(a)
    c = ''
    for i in b :
        c += i * a
    print(c)