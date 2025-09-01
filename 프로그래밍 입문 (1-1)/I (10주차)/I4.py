import string

def is_punctuation(c : str) -> bool :
    for s in string.punctuation :
        if (c == s) :
            return True
        
    return False

a = str()
l = list()

while True :
    try :
        a = input().lower()
    except EOFError :
        break

    if (a == '') :
        break

    l.append(a)

for i in range(len(l)) :
    b = ''.join(c for c in l[i] if not is_punctuation(str(c)) or str(c) == ' ')
    print(b)