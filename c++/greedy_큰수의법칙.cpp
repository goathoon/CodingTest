#include <iostream>
#include <queue>

using namespace std;

int main()
{
  int N, M, K;
  int big;
  int big2;
  int sum = 0;
  cin>> N >> M >> K;
  priority_queue<int> pq;
  for(int i = 0; i< N; i++)
    {
      cin >> big;
      pq.push(big);
    }
  big = pq.top();
  pq.pop();
  big2 = pq.top();
  pq.pop();

  // M의 개수가 많다면 어떻게할것인가?
  //반복되는 배열의 양상을 활용
  int count; //반복되는 배열의 수 6,6,6,5 6,6,6,5 가 계속 반복될 수도 K = 3이라면,
  count = (M/(K+1)) * K + M % (K+1);
  sum += big * count;
  sum += (M - count) * big2; //반복되는 양상에서 두번쨰로 큰수는 한번씩 더함.
  cout << sum <<endl;
  }