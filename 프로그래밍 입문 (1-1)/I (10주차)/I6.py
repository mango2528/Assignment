
# !-- 입력 파일의 위치와 이름은 Desktop\의 shopping.txt 임 --!
# !-- 출력 파일의 위치와 이름은 Desktop\의 buy.txt 임 --!

input_file_name = r"Desktop\shopping.txt"
f = open(input_file_name, 'r')

product = list()
count = list()
price = list()

while True :
    try :
        line = f.readline().split()
    except EOFError :
        break

    if (line == []) :
        break

    product.append(line[0])
    count.append(int(line[1]))
    price.append(int(line[2]))

output_file_name = r"Desktop\buy.txt"
f = open(output_file_name, 'w')

for i in range(len(product)) :
    f.write(f"{product[i]} {count[i] * price[i]}\n")

f.close()