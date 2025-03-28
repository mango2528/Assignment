num = int(input())

if num >= 3 and num <= 5 :
    print('Spring')
elif num >= 6 and num <= 8 :
    print('Summer')
elif num >= 9 and num <= 11 :
    print('Autumn')
elif num == 12 or num == 1 or num == 2 :
    print('Winter')

if num < 1 or num > 12 :
    print('Wrong')