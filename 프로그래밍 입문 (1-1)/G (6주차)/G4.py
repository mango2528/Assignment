a = list(map(int, input().split()))

def get_sum_and_average(list : list[float]) -> list :
    list.remove(min(list))
    list.remove(max(list))

    _sum = int(sum(list))
    average = float(f'{(sum(list) / len(list)):.1f}')

    return [_sum, average]

b = get_sum_and_average(a)

print(f'Sum = {b[0]}, Average = {b[1]}')