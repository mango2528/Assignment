from typing import List

def get_words(sentence : str, a : str) -> List[str] :
    outs : List[str] = list()
    words : List[str] = sentence.split()

    for i in range(len(words)) :

        if (words[i].upper().startswith(a.upper())) :
            outs.append(words[i])

    return outs

if __name__ == '__main__' :
    _a = input()
    _sentence = input()

    _words = get_words(_sentence, _a)

    for i in range(len(_words)) :
        print(_words[i])

# Python consistently ranks as one of the most popular programming languages.

# This tutorial introduces the reader informally to the basic concepts and features of the Python language and system. 