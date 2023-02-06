import sys
input = sys.stdin.readline
N, M = map(int, input().split())
N_list = []
for i in range(N) :
    N_list.append(list(map(int,input().split())))

def subtotals(arr :[list()]) :
    sum_list = arr
    for i in range(len(sum_list)) :
        for j in range(1, len(sum_list[0])) :
            sum_list[i][j] = sum_list[i][j] + sum_list[i][j-1]

    for i in range(1, len(sum_list)) :
        for j in range(len(sum_list)) :
            sum_list[i][j] = sum_list[i][j] + sum_list[i-1][j]
    return sum_list
    
sum_list_result = subtotals(N_list)

def result(arr : [list()], x1, y1, x2, y2) :
    if x1 == 1 and y1 == 1:
        return arr[x2-1][y2-1]
    elif x1 == 1 :
        return arr[x2-1][y2-1] - arr[x2-1][y1-2]
    elif y1 == 1 :
        return arr[x2-1][y2-1] - arr [x1-2][y2-1] 
    else :
        return arr[x2-1][y2-1] - arr [x1-2][y2-1] - arr[x2-1][y1-2] + arr[x1-2][y1-2]

for i in range(M):
    a, b, c, d =map(int,input().split())
    print(result(sum_list_result, a, b, c, d))


# for i in range(M) :
#     N_sum = 0
#     x1, y1, x2, y2 = map(int, input().split())
#     for i in range(x2 - x1 + 1) :
#         for j in range(y2 - y1 + 1) :
#             N_sum += N_list[x1 - 1 + i][y1 - 1 + j]
#     print(N_sum)
