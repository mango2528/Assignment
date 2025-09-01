
string = input().split()

try :
    a = float(string[0])
    b = float(string[1])
    c = float(string[2])
except ValueError :
    print("Wrong input")
    print("Done")
    exit()

try :
    x1 = (-b + ((b ** 2) - (4 * a * c)) ** 0.5) / (2 * a)
    x2 = (-b - ((b ** 2) - (4 * a * c)) ** 0.5) / (2 * a)
except ZeroDivisionError :
    print("No root")
    print("Done")
    exit()

if (x1 == x2) : # 중근
    print(f"x = {x1:.1f}")
    print("Done")
    exit()

try : # 복소수 판단
    x1 = float(x1)
    x2 = float(x2)
except :
    print("Imaginary root")
    print("Done")
    exit()

print(f"x1 = {x1:.1f}, x2 = {x2:.1f}")
print("Done")
