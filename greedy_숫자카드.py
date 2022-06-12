n, m = map(int, input().split())

answer = 0
for i in range(n):
  cards = list(map(int,input().split()))
  min_card = min(cards)
  answer = max(answer,min_card)
print(answer)