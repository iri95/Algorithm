a = {}
for i in range(97,123) :
    a[chr(i)] = -1
N = input()
for i in range(len(N)) :
    if a[N[i]] != -1 :
        continue        
    a[N[i]] = i
for i in a.values() :
    print(i, end=' ')
