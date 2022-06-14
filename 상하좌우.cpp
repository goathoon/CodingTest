// cin으로 입력 받으면 엔터가 버퍼에 남아있기 때문에,
// 다음 입력을 받기 위해서는 반드시 버퍼를 비워줘야 한다.

#include <iostream>
#include <string>

struct _point
{
    int x, y;
}point;

using namespace std;

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
char moves[4] = {'R','D','L','U'};

int main()
{
    point.x = 1;
    point.y = 1;
    int number;
    cin >> number;
    cin.ignore();

    string plans;
    getline(cin,plans);
    for(int i = 0; i<plans.size() ; i++)
    {
        char plan = plans[i];
        for(int j = 0; j<4; j++)
        {
            if(plan == moves[j])
            {
                point.x += dx[j];
                point.y += dy[j];
            }
            if(point.x > number || point.x ==0 || point.y >number || point.y ==0)
            {
                point.x -=dx[j];
                point.y -=dy[j];
            }
        }

    }
    cout << point.x << ' ' << point.y;
}