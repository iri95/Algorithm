import sys
input = sys.stdin.readline
N, H = map(int,input().split())

top = [0 for i in range(H)]     # index 0부터 H층 H-1층 ...
bottom = [0 for i in range(H)]  # index 0부터 1층 2층 ...
for i in range(N//2) :          # N에는 짝수만 입력되므로 // 사용
    top[int(input())-1] += 1    # 종유석
    bottom[int(input())-1] += 1 # 석순

for i in range(1, H) :                  # 1부터 모든 인덱스 순회
    top[H - i - 1] += top[H - i]        # 누적합 적용
    bottom[H - i - 1] += bottom[H - i]  # 누적합 적용

count = 0       # 최소값 개수
min_road = N    # 장애물이 적은 길의 장애물 수

for i in range(H) :                         # 길의 수만큼 순회
    sum_road = bottom[i] + top[H - 1 - i]   # 현재 길의 장애물 수
    if min_road > sum_road :                # 만약 장애물의 최소값이 더 크다면
        count = 1                               
        min_road = sum_road     
    elif min_road == sum_road :             # 장애물의 최소값과 같다면
        count += 1

print(min_road, count)


# road = [0 for i in range(H)]
# for i in range(N//2) :
#     for j in range(int(input())) :
#         road[j] += 1
#     for j in range(int(input())) :
#         road[H-1-j] += 1
# count = 0
# min_road = min(road)
# for num in road :
#     if num == min_road :
#         count += 1
# print(min_road, count)