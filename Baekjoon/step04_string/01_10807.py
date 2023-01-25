N = int(input()) 
v_list = list(map(int,input().split()))
v = int(input())
count = 0
for i in range(N) :
    if v_list[i] == v :
        count +=  1
print(count)