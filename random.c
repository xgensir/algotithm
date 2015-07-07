#include<stdio.h>
#include<stdlib.h>
#include<time.h>
void main()
{
 int i,j,s[3][4];
 srand((unsigned)time(NULL));//设立种子
 for(j=0;j<3;j++)
 for(i=0;i<4;i++)
  s[j][i]=4+rand()%26; //产生4-30的随机数
 for(j=0;j<3;j++)
 {
 for(i=0;i<4;i++)
  printf("%d ",s[j][i]);
 putchar('\n');
 }
}
