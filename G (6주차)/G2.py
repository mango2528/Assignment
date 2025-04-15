a = input()

def check_valid(one : str, two : str, three : str) -> float :
    if (one != '010') :
        return 'WRONG'
    if (not (two.isnumeric() and len(two)) == 4) :
        return 'WRONG'
    if (not (three.isnumeric() and len(three)) == 4) :
        return 'WRONG'
    return 'OK'

try :
    first = a.split('-')[0]
    second = a.split('-')[1]
    third = a.split('-')[2]

    print(check_valid(first, second, third))

except :
    print('WRONG')