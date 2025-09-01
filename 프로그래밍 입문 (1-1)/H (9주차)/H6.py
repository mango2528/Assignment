def get_words_length(l : list) -> dict :
    l.sort(reverse=True)
    d = dict()

    for i in range(len(l)) :
        d.update({l[i] : len(l[i])})

    return d

a = input().split()
words = get_words_length(a)

# print(words.items())

for key, value in words.items() :
    print(f'{key} : {value}')