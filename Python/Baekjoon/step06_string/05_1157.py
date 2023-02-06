a = input()
k = ''
b = {}
for i in a.upper() :
    if i not in b.keys() :
        b[i] = 1
    else :
        b[i] += 1
c = ''
c_max = 0
for key, value in b.items() :
    if c_max < value :
        c = key
        c_max = value
    elif c_max == value :
        c = '?'
print(c)
