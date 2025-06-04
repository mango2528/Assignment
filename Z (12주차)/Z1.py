import math

input = input().split()

a = math.pi * math.pow(int(input[0]), 2)
b = math.pi * math.pow(int(input[0]) + int(input[1]), 2) - a
c = math.pi * math.pow(int(input[0]) + int(input[1]) + int(input[2]), 2) - a - b

prob = b / (a + b + c)

# print(f"{a}, {b}, {c}")

print(f"{prob:.2f}")