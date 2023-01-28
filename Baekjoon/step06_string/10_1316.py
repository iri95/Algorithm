N = int(input())
count = 0
for i in range(N) :
    a = input()
    b = []
    for i in range(len(a)) :
        if a[i] not in b :
            b.append(a[i])
        elif a[i-1] == a[i] :
            pass
        elif a[i] in b :
            break
        if i == len(a)-1 :
            count += 1
print(count)

