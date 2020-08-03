#include<iostream>
using namespace std;

int main(){

 int n, x, y, z, t;
 int a[100], preXOR[100+1];
 cin>>n>>x>>y>>z>>t;

for(int i = 1 ; i <= n ; ++i){
    cin>>a[i];
    preXOR[i] = preXOR[i - 1] ^ a[i];
}

int solutionFigure = 0;
for(int i = x ; i <= z ; ++i){
    solutionFigure = (preXOR[t] ^ preXOR[y - 1]);
}

 cout<<solutionFigure;


 return 0;
}
