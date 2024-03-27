#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int idx = -1;

bool compare(vector<int> data1, vector<int> data2){
    if(data1[idx] == data2[idx]){
        return data1[0] > data2[0];
    }
    return data1[idx] < data2[idx];
}


int solution(vector<vector<int>> data, int col, int row_begin, int row_end) {
    idx = col - 1;
    sort(data.begin(),data.end(),compare);
    int answer = 0;
    for(int x : data[row_begin-1]){
        answer += (x%row_begin);
    }
    for(int i = row_begin; i <= row_end-1; i++){
        int add = 0;
        for(int x : data[i]){
            add += (x%(i+1));
        }
        answer = answer^add;
    }
    return answer;
}