#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    int N;
    cin>>N;
    int *arr = new int[N];
    int *dp = new int[N];
    for(int i = 0; i < N; i++){
        int h;
        cin>>h;
        arr[i] = h;
        dp[i] = 1;
    }
    int ans = 0;
    for(int i = 0; i < N; i++){
        for(int j = i-1 ; j >= 0; j--){
            if(arr[i] > arr[j]){
                dp[i] = max(dp[j]+1,dp[i]);
            }
        }
        ans = max(dp[i],ans);
    }
    cout<<ans;
    return 0;
}