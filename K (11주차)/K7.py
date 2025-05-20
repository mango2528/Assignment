
# ----- <!> -------------------------
#
# 과제 K1을 import하여 사용함
#
# ----- <!> -------------------------

import K1 as k

if (__name__ == "__main__") :
    k.init()
    s = int(input("정사각형 변 길이 입력..."))
    k.draw_adjacent_square(s=s)
    input("NAGA")