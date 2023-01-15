T = int(input())
for test_case in range(1,T+1):
    number = int(input())
    score = list(map(int,input().split()))
    dict_score = {}
    for num in score:
        if num not in dict_score:
            dict_score[num] = 1
        else :
            dict_score[num] += 1
    reverse_dict = dict(map(reversed,sorted(dict_score.items())))
    print(f"#{number} {reverse_dict[max(reverse_dict.keys())]}")