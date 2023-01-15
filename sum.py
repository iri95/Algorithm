for test_case in range(10):
    T = int(input())
    squre = []
    sum_list=[]
    cross_list = []
    reverse_cross_list = []
    for k in range(100):
        squre.append(list(map(int,input().split())))
    for i in range(100):
        column_list = []
        for j in range(100):
            column_list.append(squre[j][i])
        cross_list.append(squre[i][i])
        reverse_cross_list.append(squre[i][99-i]) 

        sum_list.append(sum(squre[i]))
        sum_list.append(sum(column_list))
    sum_list.append(sum(cross_list))
    sum_list.append(sum(reverse_cross_list))
    print(f"#{T} {max(sum_list)}")