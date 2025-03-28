a = str(input())

index = a.find(' ')
length = len(a)

# print(a[0:index] + ' ' + a[index:length - 1] + 'X')

w = float(a[0:index])
t = float(a[index:length])
bmi = round((w / (t / 100) ** 2), 1)
status = ''

# print(str(w) + ' ' + str(t) + ' ' + str(bmi))

if bmi < 18.5 :
    status = 'Underweight'
elif bmi >= 18.5 and bmi < 25.0 :
    status = 'Healthy Weight'
elif bmi >= 25.0 and bmi < 30.0 :
    status = 'Overweight'
elif bmi >= 30.0 :
    status = 'Obesity'

print('BMI = ' + str(bmi) + ': ' + status)