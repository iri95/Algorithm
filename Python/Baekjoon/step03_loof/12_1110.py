# N = int(input())
# k = N
# l = 0
# for i in range(2) :
#     l += k % 10
#     k = k // 10
# k = (N % 10) * 10 + l % 10
# count = 1
# while N != k:
#     l = 0
#     m = k
#     for i in range(2) :
#         l += k % 10
#         k = k // 10
#     k = (m % 10) * 10 + l % 10
#     count += 1
# print(count)

N = int(input())
n = N
count = 0
while True :
    k = n % 10 + n // 10
    n = k % 10 + (n % 10) * 10
    count += 1
    if N ==n : break
print(count)