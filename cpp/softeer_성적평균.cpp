#include<iostream>
#include<cmath>
#include<vector>
using namespace std;

double round_digit(double ans){
    return round(ans * 100)/100;
};

int main(int argc, char** argv)
{
    int N,K;
    cin>>N>>K;
    vector<int>v;
    vector<int>dp;
    for(int i = 0; i < N; i++){
        int x;
        cin>>x;
        v.push_back(x);
        if(i>=1){
            dp.push_back(dp[i-1]+x);
        }
        else{
            dp.push_back(x);
        }
    }
    for(int j = 0; j < K; j++){
        double a,b;
        double ans;
        cin>>a>>b;
        if(a==1){
            ans = round_digit(dp[b-1]/(b-a+1));
        }
        else{
            ans = round_digit((dp[b-1]-dp[a-2])/(b-a+1));
        }
        printf("%.2f\n",ans);
    }
    return 0;
}

