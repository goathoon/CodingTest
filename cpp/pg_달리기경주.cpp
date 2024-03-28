#include <string>
#include <vector>
#include <map>
#include <iostream>
using namespace std;

void change(vector<string>& players, map<string,int>&map, int idx){
    string callee = players[idx];
    string temp = players[idx-1];
    players[idx-1] = callee;
    players[idx] = temp;
    map[callee] = map[callee]-1;
    map[temp] = map[temp]+1;
}

vector<string> solution(vector<string> players, vector<string> callings) {
    map<string,int> map;
    for(int i = 0; i < players.size(); i++){
        map[players[i]] = i;
    }
    for(string s : callings){
        change(players,map,map[s]);
    }
    return players;
}

