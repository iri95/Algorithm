a, b = input().split()
rev_a = ''.join(reversed(a))
rev_b = ''.join(reversed(b))
if int(rev_a) > int(rev_b) :
    print(rev_a)
else :
    print(rev_b)