number = list(range(1,10001))
for i in range(1,10001) :
    i_sum = i
    for j in range(len(str(i))) :
        i_sum += i%10
        i = i//10
    if i_sum in number :
        number.remove(i_sum)
for c in number :
    print(c)