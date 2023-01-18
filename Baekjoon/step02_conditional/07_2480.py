dice = list(map(int,input().split()))
# count = [0,0,0,0,0,0]
# if len(set(dice)) == 3 :
#     print(f'{max(dice) * 100}')
# elif len(set(dice)) == 2 :
#     for i in dice :
#         count[i-1] += 1
#     for j in range(6) :
#         if count[j] == 2 :
#             print(f'{(j+1)*100 + 1000}')
# else :
#     print(f'{10000 + dice[0] * 1000}')

if dice[0] == dice[1] == dice[2] :
    print(f'{10000 + dice[0] * 1000}')
elif dice[0] == dice[1] :
    print(f'{dice[0]*100 + 1000}')
elif dice[1] == dice[2] :
    print(f'{dice[1]*100 + 1000}')
elif dice[2] == dice[0] :
    print(f'{dice[0]*100 + 1000}')
else :
    if dice[0] > dice[1] and dice[0] > dice[2] :
        print(f'{dice[0] * 100}')
    elif dice[1] > dice[0] and dice[1] > dice[2] :
        print(f'{dice[1] * 100}')
    else :
        print(f'{dice[2] * 100}')


    