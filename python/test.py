cell = [["EMPTY" for _ in range(51)] for _ in range(51)]
for row in range(51):
    for col in range(51):
        print(id(cell[row][col]))
id(cell[50][50]) = id(cell[50][49])
cell[50][50] = "hihi"

for row in range(51):
    for col in range(51):
        print(cell[row][col])