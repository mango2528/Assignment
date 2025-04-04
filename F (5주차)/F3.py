a = float(input())
b = float(input())
c = float(input())

# ---- 함수 --------------------------------------------------------

def get_sum(x : float, y : float, z : float) -> float :
    return x + y + z

def get_avg(x : float, y : float, z : float) -> float :
    return (x + y + z) / 3

def get_sqrt(x : float, y : float, z : float) -> float :
    return (x ** 2 + y ** 2 + z ** 2) ** 0.5

# ---- 함수 --------------------------------------------------------

print(f'Sum: {get_sum(a, b, c):.2f}')
print(f'Average: {get_avg(a, b, c):.2f}')
print(f'Square root of sum of squares: {get_sqrt(a, b, c):.2f}')