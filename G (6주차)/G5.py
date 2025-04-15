a = list(map(int, input().split(',')))

def get_postive_sum(list : list[float]) :
    sum = int()

    if (list == []) :
        return 0

    for i in range(len(list)) :
        if (list[i] > 0) :
            sum += list[i]

    return sum

print(f'Sum = {get_postive_sum(a)}')
