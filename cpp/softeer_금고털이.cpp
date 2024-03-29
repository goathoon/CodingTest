#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

bool sorting(pair<int,int> v1, pair<int,int> v2){
    return v1.second > v2.second;
}
int main(int argc, char** argv)
{
    int W,N;
    cin>>W>>N;
    vector<pair<int,int>> v;
    for(int i = 0; i < N; i++){
        int w;
        int p;
        cin>>w>>p;
        v.push_back(make_pair(w,p));
    }
    sort(v.begin(),v.end(),sorting);
    int curW = 0;
    int ans = 0;
    for(int i = 0; i < v.size(); i++){
        if(v[i].first <= W-curW){
            curW += v[i].first;
            ans += v[i].second * v[i].first;
        }
        else{
            ans += v[i].second * (W-curW);
            break;
        }
    }
    cout<<ans;
}