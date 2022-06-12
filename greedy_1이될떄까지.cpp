#include <iostream>
using namespace std;
int main()
{
  int N, K;
  int count = 0;
  int rest;
  cin >> N >> K;
  while(N != 1)
    {
      rest = N % K;
      count += rest;
      N = N - rest;
      if( N ==0)
        break;
      N = N/K;
      count++;
    }
  cout << count;
  
  
  
}