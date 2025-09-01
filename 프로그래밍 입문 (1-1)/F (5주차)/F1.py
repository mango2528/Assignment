from time import time

a = int(input())

opt = [None] * int(a)

if (a >= 997) :
    raise RecursionError

# ---- 함수 ------------------------------------

def fib(n : int) -> int :
    if (n == 0) :
        return 0
    
    if (n == 1) :
        return 1
    
    return optmize_fib(n)

# ---- 함수 ------------------------------------

def optmize_fib(n : int) -> int :
    if (opt[n - 1] == None) :
        opt[n - 1] = fib(n-2) + fib(n-1)
        return opt[n - 1]
    else :
        return opt[n - 1]
    

# time_started = time()

print(f'Fib({a}) = {fib(a)}')

# time_ended = time()

# print(f'Took {((time_ended - time_started) * 1000):.0f}ms.')

'''

def non_optimized_fib(n) :
    if (n == 0) :
        return 0
    
    if (n == 1) :
        return 1
    
    return non_optimized_fib(n-2) + non_optimized_fib(n-1)

print(f'Fib({a}) = {non_optimized_fib(int(a))}')

'''