import sys

case = int(input())
for _ in range(case):
    v,e,w = map(int,input().split())
    check = False
    edge_list = []
    for _ in range(e):
        start,end,cost = map(int,sys.stdin.readline().split())
        edge_list.append((start,end,cost))
        edge_list.append((end,start,cost))
    for _ in range(w):
        start,end,cost = map(int,sys.stdin.readline().split())
        edge_list.append((start,end,-cost))
    dist = [987654321] * (v+1)
    """
    본래 벨만포드 알고리즘은 음수 간선을 포함한 그래프의 상황에서,
    한 정점에서 다른 정점으로 가는 최소거리를 구할때 사용하는 알고리즘이다.
    하지만 해당문제에서 모든 정점에서 벨만포드를 구하여 "음의 사이클"이 존재하는지 여부를 구하면
    시간복잡도가 (v^2 * e)가 되어 오바한다.
    근데 사실상 음의 사이클을 구하면 되는 문제라는 것을 확인했을 때, 어떠한 정점에서든 시작해도 
    결국 음의사이클만 구하면 된다. 그러면 모든 정점(시작)에서 출발하여 도착지점으로 도착할 때,
    무조건 시간이 거꾸로 가있기 때문이다.
    다시말해 여러번 웜홀을 타고 양방향 도로를 타서 다시 출발지점으로 도착하면 장땡이다.
    따라서 dist 원소가 987654321 가 아닌 인덱스를 탈 것이 아니라, 모든 정점에서의 간선을 한번씩 다 방문하여
    음의 사이클이 존재하는지 확인만 하자.
    """
    dist[1] = 0
    
    #정점의 개수 만큼 반복하여 dist테이블 (최단거리 테이블을 계속해서 업데이트) 을 업데이트한다
    #하지만 이때, 마지막 v번 시행시에도 업데이트가 된다는 것은 결국 음의 사이클이 발생했다는 뜻이므로, 결국 출발지점까지
    #시간이 거꾸로된 상태로 도달할 수 있다는 뜻이된다.
    
    for i in range(v):
        for edge in edge_list:
            cur_node,next_node,cost = edge
            if dist[next_node] > dist[cur_node] + cost: #dist[cur_node] 가 무한인지 확인하는 과정을
                #여기서는 거치지 않는다. 음의 사이클이 존재하는 지만 확인할 것이기 때문이다.
                dist[next_node] = dist[cur_node] + cost
                if i == v-1: 
                    check = True
    if check:
        print("YES")
    else:
        print("NO")
    