T = int(input())
for test_case in range(1,T+1):
    N = int(input())
    spin_list = []
    for line in range(N):
        spin_list.append(input().split())
    print(f"#{test_case}")
    # [N-j][i] > [N-j][i] , [N-i][N-j] > [N-i][N-j], [j][N-i] > [N(j)][N-i]
    for i in range(N):
        for j in range(N):
            print(spin_list[N-j-1][i],end="")
        print(" ",end="")
        for j in range(N):
            print(spin_list[N-i-1][N-j-1],end="")
        print(" ",end="")
        for j in range(N):
            print(spin_list[j][N-i-1],end="")
        print("")