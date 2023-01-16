T = int(input())
for test_case in range(1,T+1):
    length = list(map(int,input().split()))
    A = list(map(int,input().split()))
    B = list(map(int,input().split()))
    maximum = 0
    mul = []
    for i in range(abs(length[0]-length[1])+1):
        if length[0] < length[1] :
            k = 0
            for j in range(length[0]):
                k += A[j]*B[i+j]
            mul.append(k)
        if length[1] < length[0] :
            k = 0
            for j in range(length[1]):
                k += B[j]*A[i+j]
            mul.append(k)
    maximum = max(mul)
    print(f"#{test_case} {maximum}")
