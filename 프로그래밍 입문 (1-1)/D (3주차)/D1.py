unit = str(input())
num = float(input())

cel = 0
fah = 0

if unit == 'C' :
    cel = num
    fah = 9 / 5 * num + 32
    print('Celsius = ' + f'{cel:.1f}' + ', Fahrenheit = ' + f'{fah:.1f}')
elif unit == 'F' :
    fah = num
    cel = 5 / 9 * num - (160 / 9)
    print('Fahrenheit = ' + f'{fah:.1f}' + ', Celsius = ' + f'{cel:.1f}')