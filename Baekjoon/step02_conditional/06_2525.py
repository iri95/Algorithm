hour, minute = map(int,input().split())
time = int(input())
# time_hour = time // 60
# time_minute = time % 60
# end_minute = (minute+time_minute) % 60
# end_time = ((hour + time_hour) + (minute + time_minute) // 60) % 24 
# print(f'{end_time} {end_minute}')

if time + minute >= 60 :
    hour = (hour + (time + minute) // 60) % 24
    minute = (time+minute) % 60
    print(f'{hour} {minute}')
else :
    minute = minute + time
    print(f'{hour} {minute}')
    