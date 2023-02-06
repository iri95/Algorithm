count = 0
N = int(input())
count = 0
for i in range(1, N + 1) :
    k = str(i)
    result = []
    for j in range(len(k)-1) :
        result.append(int(k[j])-int(k[j+1]))
    if len(set(result)) > 1 :
        pass
    else :
        count += 1
print(count)
