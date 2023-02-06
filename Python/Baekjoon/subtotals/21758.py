# import sys
input = sys.stdin.readline
N = int(input())
honey = list(map(int, input().split()))
revers_honey = list(reversed(honey))

if sum(honey[1:len(honey)]) - min(honey[1:len(honey)-1])+ sum(honey[honey.index(min(honey[1:len(honey)-1]))+1:len(honey)]) > sum(honey[2:len(honey)]) * 2 :
    a = sum(honey[1:len(honey)]) - min(honey[1:len(honey)-1])+ sum(honey[honey.index(min(honey[1:len(honey)-1]))+1:len(honey)]) 
else :
    a = sum(honey[2:len(honey)]) * 2

b = sum(honey[1:len(honey)-1]) + max(honey[1:len(honey)-1])

if sum(revers_honey[1:len(honey)]) - min(revers_honey[1:len(honey)-1])+ sum(revers_honey[revers_honey.index(min(revers_honey[1:len(honey)-1]))+1:len(honey)]) > sum(revers_honey[2:len(honey)]) * 2 :
    c = sum(revers_honey[1:len(honey)]) - min(revers_honey[1:len(honey)-1])+ sum(revers_honey[revers_honey.index(min(revers_honey[1:len(honey)-1]))+1:len(honey)]) 
else :
    c = sum(revers_honey[2:len(honey)]) * 2

print(max(a, b, c))