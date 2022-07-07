#include <iostream>
#include <stdbool.h>

using namespace std;

bool check(int x,int k);

int main()
{
    int N , K;
    int count = 0;
    cin >> N >> K;
    for(int i = 0; i<=N; i++)
    {
        if(check (i,K))
        {
            count += 60*60;
            continue;
        }    
        for(int j = 0; j<60; j++)
        {
            if(check(j,K))
            {
                count+=60;
                continue;
            }
            for (int k = 0; k<60; k++)
            {
                if(check(k,K))
                    count++;
            }
        }
    }
    cout << count;
}

bool check(int x, int k)
{
    if(x/10 == k)
        return true;
    else if(x % 10 == k)
        return true;
    else
        return false;
}
