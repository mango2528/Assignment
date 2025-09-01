num = str(input())

if num[0] != 'K' :
    print('False')
    exit()
    
if len(num) != 10 :
    print('False')
    exit()

if (num[1:9]).isdigit() == False :
    print('False')
    exit()

print('True')
