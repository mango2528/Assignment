
# ----- <!> -------------------------
#
# 과제 K1을 import하여 사용함
#
# ----- <!> -------------------------

import K1 as k

if (__name__ == "__main__") :
    k.init()
    s = int(input("정사각형 변 길이 입력..."))
    k.draw_square(s, s)
    k.draw_square(2 * s, 2 * s)
    k.draw_square(4 * s, 4 * s)
    input("NAGA")