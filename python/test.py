import math
def fixed_point_iteration(g, x, iters):
    x_prev = x
    for i in range(iters):
        print("doing", x_prev,i)
        x_next = g(x_prev)
        if abs(x_next - x_prev) < 1e-8:
            return x_next
        x_prev = x_next


solution = fixed_point_iteration(lambda x:math.exp(x)+math.sin(x)-4 , 1.1,10000)
print(solution)

# import math

# def fixed_point_iteration(g, x0, tol=1e-8, max_iters=100):
#     """
#     Applies Fixed-Point Iteration to find the solution of the equation g(x) = x up to a certain tolerance
#     and maximum number of iterations.
    
#     Args:
#         g (function): The function whose fixed point is to be found
#         x0 (float): The initial guess for the fixed point
#         tol (float): The tolerance level for the convergence of the fixed point, default is 1e-8
#         max_iters (int): The maximum number of iterations, default is 100
        
#     Returns:
#         x (float): The fixed point of the function g(x)
#     """
#     x_prev = x0
#     for i in range(max_iters):
#         x_next = g(x_prev)
#         if abs(x_next - x_prev) < tol:
#             return x_next
#         x_prev = x_next
#     raise Exception(f"Failed to converge in {max_iters} iterations")

# # Example usage:
# # (a) x3 = 2x + 2 using g(x) = (x^3 - 2) / 2
# # (b) ex + sin(x) = 4 using g(x) = 4 - math.exp(x)

# # (a)
# def g_a(x):
#     return x**3 - 2*x - 2

# solution_a = fixed_point_iteration(g_a, 1)
# print(f"The solution to x^3 = 2x + 2 is approximately {solution_a:.8f}")

# # (b)
# def g_b(x):
#     return 4 - math.exp(x) - math.sin(x)

# solution_b = fixed_point_iteration(g_b, 1)
# print(f"The solution to e^x + sin(x) = 4 is approximately {solution_b:.8f}")