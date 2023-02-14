import sys
N, find = map(int, input().split())
site_dict = {}
for _ in range(N):
    site, pwd = sys.stdin.readline().strip().split()
    site_dict[site] = pwd

for _ in range(find):
    find_site = sys.stdin.readline().strip()
    print(site_dict[find_site])
