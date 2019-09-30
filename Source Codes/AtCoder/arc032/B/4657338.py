#!/usr/bin/env python3
import sys

class UnionFind:
    def __init__(self, n):
        # par = Parent Number or NoV
        self.par = [-1] * (n+1)
        # rank = Tree Height
        self.rank = [0] * (n+1)
    
    # ??????????????
    def size(self, x):
        return -1*self.par[self.find(x)]

    # ????????
    def find(self, x):
        
        if(self.par[x] < 1):
            return x
        self.par[x] = self.find(self.par[x])
        return self.par[x]

    # ???????
    def same_check(self, x, y):
        return self.find(x) == self.find(y)

    def union(self, x, y):
        # ????
        x = self.find(x)
        y = self.find(y)

        # ????????
        if(x == y):
            return False

        # ??????
        if(self.size(x) < self.size(y)):
            x,y = y,x
        
        # x???????
        self.par[x] += self.par[y]
        # y????(??????)?x?
        self.par[y] = x

        return True 

from collections import defaultdict

def solve(N: int, M: int, a: "List[int]", b: "List[int]"):
    uf = UnionFind(N)
    for i in range(M):
        uf.union(a[i], b[i])

    ans = len([i for i in uf.par[1:] if i < 0])-1
    print(ans)
    
    return


# Generated by 1.1.3 https://github.com/kyuridenamida/atcoder-tools  (tips: You use the default template now. You can remove this line by using your custom template)
def main():
    def iterate_tokens():
        for line in sys.stdin:
            for word in line.split():
                yield word
    tokens = iterate_tokens()
    N = int(next(tokens))  # type: int
    M = int(next(tokens))  # type: int
    a = [int()] * (M)  # type: "List[int]" 
    b = [int()] * (M)  # type: "List[int]" 
    for i in range(M):
        a[i] = int(next(tokens))
        b[i] = int(next(tokens))
    solve(N, M, a, b)

if __name__ == '__main__':
    main()