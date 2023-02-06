a = input()
cro_list = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']    
count = 0
for i in cro_list :
    if i in a :
        count += a.count(i)
        a = a.replace(i,' ',)
a = a.replace(' ', '')
count += len(a)
print(count)