#include <string>
#include <vector>
#include <cmath>
using namespace std;

vector<int> solution(vector<string> wallpaper) {
    vector<int> answer;
    int sc = 999999999, lc = -1;
    int sr = 999999999, lr = -1;
    for(int r = 0; r < wallpaper.size(); r++){
        for(int c = 0; c < wallpaper[r].size(); c++){
            if(wallpaper[r].at(c) == '#'){
                sc = min(sc,c);
                lc = max(lc,c+1);
                sr = min(sr,r);
                lr = max(lr,r+1);
            }
        }
    }
    answer.push_back(sr);
    answer.push_back(sc);
    answer.push_back(lr);
    answer.push_back(lc);
    return answer;
}