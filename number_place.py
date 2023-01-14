T = int(input())
a = [1,2,3,4,5,6,7,8,9]
for test_case in range(1,T+1):
    sdocu = []
    result = 1
    for j in range(9):
        sdocu.append(list(map(int,(input().split()))))
    for k in range(9):
        a_sum = 0
        b_sum = 0
        c_sum = 0
        b_set = set()
        c_set = set()
        if len(set(sdocu[k]))!=9:
            result = 0
            break
        for l in range(9):
            if sdocu[k][l] not in a and sdocu[l][k] not in a and sdocu[3*k%9+l//3][k//3*3+l%3] not in a:
                result = 0
            else :
                b_set.add(sdocu[l][k])
                c_set.add(sdocu[3*k%9+l//3][k//3*3+l%3])
                a_sum += sdocu[k][l]
                b_sum += sdocu[l][k]
                c_sum += sdocu[3*k%9+l//3][k//3*3+l%3]  
        if a_sum != 45 or b_sum != 45 or c_sum != 45 or len(b_set) !=9 or len(c_set) != 9:
            result = 0
    print(f"#{test_case} {result}")