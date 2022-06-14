#include <iostream>
using namespace std;

int main()
{
    char a[100], b[100], c[100];
    cin >> a; //cin 이 엔터까지 인식해서 cin 하고 나서는 cinignore의 명령어가 반드시 필요하다.
    //cin은 공백(띄어쓰기 엔터 탭) 다 무시.하지만 버퍼에는 이 정보들이 그대로 남아있다. 그래서 다음 cin에서 엔터 탭 띄어쓰기같은 정보가 버퍼에 씌워진채로, 그 후에
    //입력되는 공백을 무시함. 따라서 먼저 앞 cin에서 이루어진 띄어쓰기가 버퍼에 남아있으므로 이를 cin에 포함시키게 됨.
    //하지만 getline은 엔터를 버퍼에 남기지 않음.
    cin.getline(b, 100);
    cin.getline(c, 100);
    cout <<"a:"<< a<< endl;
    cout <<"b:"<< b<< endl;
    cout <<"c:"<< c<< endl;
    return 0;

}