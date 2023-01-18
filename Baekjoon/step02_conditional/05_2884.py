hour, minute = map(int,input().split())
if minute < 45 :
    if hour == 0 :
        print(f'23 {minute + 15}')
    else :
        print(f'{hour - 1} {minute + 15}')
else :
    print(f'{hour} {minute - 45}')