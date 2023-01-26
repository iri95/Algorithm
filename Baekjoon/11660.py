import sys
input = sys.stdin.readline
N, M = map(int, input().split())
N_list = []
for i in range(1, N + 1) :
    N_list.append(list(map(int,input().split())))

for i in range(M) :
    N_sum = 0
    x1, y1, x2, y2 = map(int, input().split())
    for i in range(x2 - x1 + 1) :
        for j in range(y2 - y1 + 1) :
            N_sum += N_list[x1 - 1 + i][y1 - 1 + j]
    print(N_sum)
# https://velog.io/@ohdowon064/Algorithm-2%EC%B0%A8%EC%9B%90-%EB%B0%B0%EC%97%B4-%EB%B6%80%EB%B6%84%ED%95%A9-%EB%88%84%EC%A0%81%ED%95%A9-%EA%B5%AC%ED%95%98%EA%B8%B0