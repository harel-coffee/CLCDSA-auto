#include<stdio.h>
int main(){
    int a,b,c;
    scanf("%d %d %d",&a,&b,&c);
    if(a+b==c && a-b==c){
        printf("?\n");
    }else if(a+b==c){
        printf("+\n");
    }
    else if(a-b==c){
        printf("-\n");
    }
    else{
        printf("!\n");
    }
    return 0;

} ./Main.c: In function �main�:
./Main.c:4:5: warning: ignoring return value of �scanf�, declared with attribute warn_unused_result [-Wunused-result]
     scanf("%d %d %d",&a,&b,&c);
     ^