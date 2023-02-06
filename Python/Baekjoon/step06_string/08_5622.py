di_dict = {'ABC' : 3, 'DEF' : 4, 'GHI' : 5, 'JKL' : 6, 'MNO' : 7, 'PQRS' : 8, 'TUV' : 9, 'WXYZX' : 10}
a = input()
di_sum = 0
for i in a :
    for key,value in di_dict.items() :
        if i in key :
            di_sum += value
print(di_sum)