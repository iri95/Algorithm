all_list = list(map(int,range(1,31)))
for i in range(28) :
    all_list.remove(int(input()))
print(min(all_list))
print(all_list.pop())