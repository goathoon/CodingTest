#include <string>
#include <vector>
#include <cmath>
#include <map>
#include <algorithm>
using namespace std;

int getMin(string s){
    return stoi(s.substr(0,2)) * 60 + stoi(s.substr(3,5));
}

int cal(double x,int free, int base, int div, int mult){
    if(x < free) return base;
    return base + ceil((x-free)/div) * mult;
}
vector<int> solution(vector<int> fees, vector<string> records) {
    int free = fees[0];
    int base = fees[1];
    int div = fees[2];
    int mult = fees[3];

    //번호-총시간
    map<int,int> cars;
    //번호-IN시간
    map<int,int> map;

    for(string s : records){
        int carNum = stoi(s.substr(6,10));

        if(s.substr(11) == "IN"){
            map[carNum] = getMin(s.substr(0,5));
        }
        else{
            if(cars.find(carNum) == cars.end()){
                cars[carNum] = getMin(s.substr(0,5)) - map[carNum];
            }
            else{
                cars[carNum] += getMin(s.substr(0,5)) - map[carNum];
            }
            map.erase(carNum);
        }
    }


    for(pair p : map){
        int carNum = p.first;
        if(cars.find(carNum) == cars.end()){
            cars[carNum] = 23*60+59 - map[carNum];
        }
        else{
            cars[carNum] += 23*60+59 - map[carNum];
        }
        map.erase(carNum);
    }
    vector<int> v;
    for(pair p : cars){
        v.push_back(p.first);
    }
    sort(v.begin(),v.end());

    vector<int> answer;
    for(int x : v){
        answer.push_back(cal(cars[x],free,base,div,mult));
    }
    return answer;
}