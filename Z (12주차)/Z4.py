a = input().split()

operator = a[0]
values = list(map(int, a[1:3]))
result = 0

# print(f"{operator}, {values}")'

if (operator == "add") :
    result = values[0] + values[1]
elif (operator == "sub") :
    result = values[0] - values[1]
elif (operator == "mul") :
    result = values[0] * values[1]
elif (operator == "div") :
    try :
        result = values[0] // values[1]
    except :
        print('X')
        exit()

print(result)