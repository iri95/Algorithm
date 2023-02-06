N, K = map(int,input().split())
level_dict = {}
for i in range(N) :
    a = input()
    if a not in level_dict.keys() :
        level_dict[a] = 1
    else :
        level_dict[a] += 1
count = 0
for j in level_dict.values() :
    count += j // K
    if j % K != 0 :
        count += 1
print(count)