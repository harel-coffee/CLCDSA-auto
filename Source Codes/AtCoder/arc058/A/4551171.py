n,_=input().split();s=set(list(input()));n=int(n);print(n+[len(s&set(str(b)))for b in range(n,99999)].index(0))