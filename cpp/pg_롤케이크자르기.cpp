#include <string>
#include <vector>
#include <map>
#include <set>
#include <iostream>
using namespace std;

int solution(vector<int> topping) {
    map<int,int> a;
    set<int> b;
    for(int x : topping){
        if(a.find(x) == a.end()){
            a[x] = 1;
        }
        else{
            a[x]++;
        }
    }
    bool isEnd = false;
    int ans = 0;
    for(int x : topping){
        b.insert(x);
        if(a.find(x)!=a.end()){
            if(a[x] == 1){
                a.erase(x);
            }
            else{
                a[x]--;
            }
        }
        if(a.size() == b.size()){
            isEnd = true;
            ans ++;
        }
        else if (isEnd && a.size()!=b.size()){
            break;
        }
    }
    if(isEnd){
        return ans;
    }
    return 0;
}