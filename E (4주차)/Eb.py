a = str(input())

nums = a.split(',')
sum = int()
count = len(nums)
avg = float()

for i in range(count) :
    sum += int(nums[i])

avg = sum / count

print(f'{count} {sum} {avg:.1f}')