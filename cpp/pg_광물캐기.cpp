#include <string>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

bool compare(vector<int> v1, vector<int> v2){
    if(v1[0] != v2[0]){
        return v1[0] > v2[0];
    }
    else if (v1[1] != v2[1]){
        return v1[1] > v2[1];
    }
    else{
        return v1[2] > v2[2];
    }
}

int solution(vector<int> picks, vector<string> minerals) {
    vector<vector<int>> v;
    int sumPicks = 0;
    for(int p : picks){
        sumPicks += p;
    }
    int size = minerals.size();
    for(int i = 0; i < sumPicks; i++){
        vector<int> iv = {0,0,0};
        for(int j = i*5; j < min(i*5+5, size); j++){
            if(minerals[j] == "diamond"){
                iv[0]++;
            }
            else if(minerals[j] == "iron"){
                iv[1]++;
            }
            else{
                iv[2]++;
            }
        }
        v.push_back(iv);
    }

    sort(v.begin(),v.end(),compare);
    int ans = 0;
    for(vector<int> x : v){
        if(picks[0] != 0){
            picks[0] --;
            ans += x[0];
            ans += x[1];
            ans += x[2];
        }
        else if(picks[1] != 0){
            picks[1] --;
            ans += x[0]*5;
            ans += x[1];
            ans += x[2];
        }
        else{
            picks[2] --;
            ans += x[0]*25;
            ans += x[1]*5;
            ans += x[2];
        }
        // printf("%d ", ans);
    }
    return ans;
}