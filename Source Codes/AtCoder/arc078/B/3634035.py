from scipy.sparse import*;f=lambda*z:map(int,input().split());n,=f();c=[1]*~-n;g,h=csgraph.dijkstra(csr_matrix((c,list(zip(*map(f,c)))),[n+1]*2),0,[1,n]);print('FSennunkeec'[sum(g[i]>h[i]for i in range(n+1))*2>=n::2])