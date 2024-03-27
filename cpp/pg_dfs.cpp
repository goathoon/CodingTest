#include <iostream>
#include <string>
#include <vector>
#include <cmath>
using namespace std;
int a=0;
int b=0;
int ans=0;

void dfsB(vector<int> cards, int visit[], int idx){
    if(visit[idx] != 0){
        return;
    }
    visit[idx] = -1;
    b+=1;
    dfsB(cards,visit,cards[idx]-1);
    visit[idx] = 0;
}

void dfsA(vector<int> cards, int visit[], int idx){
    if(visit[idx] != 0){
        for(int j = 0; j < cards.size(); j++){
            dfsB(cards,visit,j);
            ans = max(a*b,ans);
            b=0;
        }
        return;
    }
    visit[idx] = 1;
    a+=1;
    dfsA(cards,visit,cards[idx]-1);
    visit[idx] = 0;

}


int solution(vector<int> cards) {
    int visit[cards.size()];
    for(int i = 0; i < cards.size(); i++){
        visit[i] = 0;
    }
    for(int i = 0; i < cards.size(); i++){
        dfsA(cards,visit,i);
        a=0;
    }
    return ans;
}