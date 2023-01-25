N, X = map(int,input().split())
A = list(map(int,input().split()))
B = ''
for i in A :
    if X > i :
        B += f'{i} '
print(B)