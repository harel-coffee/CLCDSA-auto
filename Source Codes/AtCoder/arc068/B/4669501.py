n = int(input())
lis = list(map(int,input().split()))
ans = set()
for num in lis:ans.add(num)
print(len(ans)-((len(ans) % 2)+1)%2)