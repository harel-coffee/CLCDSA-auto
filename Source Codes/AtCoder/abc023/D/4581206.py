# python template for atcoder1
import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

N = int(input())
bal = [list(map(int, input().split())) for _ in range(N)]

l = 0
r = 10**15


def check(mid):
    T = [(mid-h)/s for h, s in bal]
    T = sorted(T)
    if all(lim <= ti for lim, ti in enumerate(T)):
        return True
    else:
        return False


while l+1 < r:
    mid = (l+r)//2
    if check(mid):
        r = mid
    else:
        l = mid
print(r)