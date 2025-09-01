a = input().split()

s = int(a[0])
w = int(a[1])

concen = s / (s + w) * 100

print(f"{concen:.1f}%")