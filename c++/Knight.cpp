#include <cstdio>
#include <iostream>
#include <string.h>
using namespace std;

int main()
{
    string input; //string이 배열로 저장
    cin>> input; 
    int x = input[0]-'a';
    int y = (int)input[1] - '1'; //a1이 입력되면 1이 문자로인식되어서 49로 int값이 바뀜 (아스키)
    int count = 0;
    
    int dx[] = {1,2,-1,-2,1,2,-1,-2};
    int dy[] = {2,1,-2,-1,-2,-1,2,1};

    for(int i =0; i<8; i++)
    {
        if(x + dx[i] >= 0 && x+dx[i]<=7 && y+dy[i] >=0 && y+dy[i]<=7)
            count++;
    }
    cout << count <<endl;
}   