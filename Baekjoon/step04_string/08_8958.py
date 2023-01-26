T = int(input())
for i in range(T) :
    a = input()
    count = 0
    sum_a = 0
    for j in a :
        if j == 'O' :
            count += 1
            sum_a += count
        else :
            count = 0
    print(sum_a)
