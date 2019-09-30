def b_island(N, A):
    s = sum(A)
    if s % N != 0:  # ????????????????????
        return -1

    # ?i??i+1????????????????????
    # ??????*?????????????????????
    return sum(1 for i in range(1, N) if sum(A[:i]) != s // N * i)

N = int(input())
A = [int(i) for i in input().split()]
print(b_island(N, A))