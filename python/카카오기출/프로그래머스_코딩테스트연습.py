# 가장 빠른 시간안에 실력을 늘려서 max_alg,max_cop를 달성하자
# 1. 그냥 공부하는게 나을수도 있고,
# 2. 가장 효율적인 문제들로만 풀어서 올릴 수도있다.
# 2번을 달성하기 위해서 가장 효율적인 문제를 풀기위해 능력치를 늘려야하는 방향으로 흘러가야한다.

# heapq 의 방식으로 최 우선순위의 문제를 먼저 고르려고 했지만, 변인이 너무 많다.

# dp의 적용범위는 다음과 같다.
# 1. Overlapping Subproblem, 반복되는 문제인가
# 2. Optimal Substructure, 작은문제의 정답을 합치는 최적의 부분 구조들에서 도출될 수 있는가

# 이문제에서는, 2번에 해당되었다. 요구되는 alp, cop에서부터 시작해서 효율적인 문제에 가장 빠른시간에 도달해서 결국 최대요구치의 alp,cop를 달성하는 것이 키 포인트다.

# ------------------ 잘못된 풀이 ------------------ ##
# def solution(alp, cop, problems):
#     # dp[alp][cop] 는 alp,cop 능력에 도달하기 위해 걸린 시간을 의미한다.
#     dp = [[0 for _ in range(181)] for _ in range(181)]
#     self_study(dp,alp,cop)
#     for problem in problems:
#         solve_problem(dp,problem)
#     max_req_alp, max_req_cop = get_max_req(problems)
#     return get_min_dp(max_req_alp,max_req_cop,dp)
    
# def self_study(dp,init_alp,init_cop):
#     for alp in range(init_alp,151):
#         for cop in range(init_cop,151):
#             dp[alp][cop] = alp+cop-(init_alp+init_cop)

# def solve_problem(dp,problem):
#     req_alp, req_cop = problem[0], problem[1]
#     rwd_alp, rwd_cop = problem[2], problem[3]
#     cost = problem[4]
#     for alp in range(req_alp,151):
#         for cop in range(req_cop,151):
#             dp[alp+rwd_alp][cop+rwd_cop] = min(dp[alp+rwd_alp][cop+rwd_cop],dp[alp][cop] + cost)


# def get_max_req(problems):
#     max_req_alp = 0
#     max_req_cop = 0
#     for problem in problems:
#         max_req_alp = max(max_req_alp, problem[0])
#         max_req_cop = max(max_req_cop, problem[1])
#     return (max_req_alp,max_req_cop)

# def get_min_dp(req_alp,req_cop,dp):
#     value = dp[req_alp][req_cop]
#     for alp in range(req_alp,151):
#         for cop in range(req_cop,151):
#             value = min(value,dp[alp][cop])
#     return value
    
################################################
# 문제 코드 2
# ## 가장 중요한것은 alp_rwd 가 30, cop_rwd 가 1 이런경우에 alp_rwd가 매우크게 커질 수 있음에 유의해야함.
# ## 	0, 0, [[0, 0, 30, 2, 1], [150, 150, 30, 30, 100]] 의 경우 생각
# ## 만일 dp = [[999999999 for _ in range(181)] for _ in range(181)]
# ## 이렇게 되버리면 5번 가서 150찍고 cop은 140 필요해서 140번 더가야함 -> 145가나옴.
# ## 너무 커버리면 마지막에서 retur
# def solution(alp, cop, problems):
#     # dp[alp][cop] 는 alp,cop 능력에 도달하기 위해 걸린 시간을 의미한다.
#     dp = [[999999999 for _ in range(151)] for _ in range(151)]
#     init_dp(alp,cop,dp)
#     for a in range(alp,151):
#         for c in range(cop,151):
#             do(a,c,problems,dp)
#     max_req_alp, max_req_cop = get_max_req(problems)
#     return get_min_dp(max_req_alp,max_req_cop,dp)
    
# def init_dp(alp,cop,dp):
#     for row in range(alp+1):
#         for col in range(cop+1):
#             dp[row][col] = 0
            
# def do(alp,cop,problems,dp):
#     dp[alp+1][cop] = min(dp[alp+1][cop],dp[alp][cop] + 1)
#     dp[alp][cop+1] = min(dp[alp][cop+1],dp[alp][cop] + 1)
#     for problem in problems:
#         req_alp, req_cop = problem[0], problem[1]
#         rwd_alp, rwd_cop = problem[2], problem[3]
#         cost = problem[4]
#         if alp >= req_alp and cop>= req_cop:
#             dp[alp+rwd_alp][cop+rwd_cop] = min(dp[alp+rwd_alp][cop+rwd_cop], dp[alp][cop] + cost)
    
        


# def get_max_req(problems):
#     max_req_alp = 0
#     max_req_cop = 0
#     for problem in problems:
#         max_req_alp = max(max_req_alp, problem[0])
#         max_req_cop = max(max_req_cop, problem[1])
#     return (max_req_alp,max_req_cop)

# def get_min_dp(req_alp,req_cop,dp):
#     value = dp[req_alp][req_cop]
#     for alp in range(req_alp,151):
#         for cop in range(req_cop,151):
#             value = min(value,dp[alp][cop])
#     return value    

def solution(alp, cop, problems):
    # dp[alp][cop] 는 alp,cop 능력에 도달하기 위해 걸린 시간을 의미한다.
    max_req_alp, max_req_cop = get_max_req(problems)
    dp = [[999999999 for _ in range(max_req_cop + 1)] for _ in range(max_req_alp + 1)]
    alp = min(max_req_alp,alp)
    cop = min(max_req_cop,cop)
    init_dp(alp,cop,dp)
    for a in range(alp,max_req_alp+1):
        for c in range(cop,max_req_cop+1):
            do(a,c,problems,dp)
    return dp[max_req_alp][max_req_cop]
    
def init_dp(alp,cop,dp):
    for row in range(alp+1):
        for col in range(cop+1):
            dp[row][col] = 0
            
def do(alp,cop,problems,dp):
    if alp + 1 < len(dp):
        dp[alp+1][cop] = min(dp[alp+1][cop],dp[alp][cop] + 1)
    if cop + 1 < len(dp[0]):
        dp[alp][cop+1] = min(dp[alp][cop+1],dp[alp][cop] + 1)
    for problem in problems:
        req_alp, req_cop = problem[0], problem[1]
        rwd_alp, rwd_cop = problem[2], problem[3]
        cost = problem[4]
        if alp >= req_alp and cop>= req_cop:
            update_alp = min(alp+rwd_alp,len(dp)-1)
            update_cop = min(cop+rwd_cop,len(dp[0])-1)
            dp[update_alp][update_cop] = min(dp[update_alp][update_cop],dp[alp][cop]+cost)
        


def get_max_req(problems):
    max_req_alp = 0
    max_req_cop = 0
    for problem in problems:
        max_req_alp = max(max_req_alp, problem[0])
        max_req_cop = max(max_req_cop, problem[1])
    return (max_req_alp,max_req_cop)
