people,party = map(int,input().split())
detect_arr = list(map(int,input().split()))
ans = party
if len(detect_arr) > 1:
    detect_arr = detect_arr[1:]
    detect_set = set(detect_arr)
else :
    detect_set = set()

people_arr = [i for i in range(0,people+1)] 
def find_parent(x):
    if people_arr[x] != x:
        people_arr[x] = find_parent(people_arr[x])
    return people_arr[x]

def union_people(x,y):
    a = find_parent(x)
    b = find_parent(y)
    if a in detect_set and b in detect_set:
        return
    elif a in detect_set:
        people_arr[b] = a #여기를 y로 하면 안되고 b를 업데이트해야함!
    elif b in detect_set:
        people_arr[a] = b
        
    else :
        if a <= b:
            people_arr[b] = a
        else :
            people_arr[a] = b
party_list = []
for _ in range(party):
    party_arr = list(map(int,input().split()))[1:]
    party_list.append(party_arr)
    for i in range(len(party_arr)-1):
        union_people(party_arr[i],party_arr[i+1])

ans = party
for i in range(len(party_list)):
    for person in party_list[i]:
        if find_parent(person) in detect_set:
            ans -=1
            break
print(ans)