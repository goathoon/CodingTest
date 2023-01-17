N = int(input())
word_set= set()
for _ in range(N):
    word_set.add(input())
word_list = list(word_set)
word_list.sort(key = lambda x : (len(x),x))
for i in range(len(word_list)):
    print(word_list[i])