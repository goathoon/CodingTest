#include <cstdio>
#include <iostream>

using namespace std;

int main()
{
  int arr[6] = {500,100,50,10,5,1};
  int cost;
  int charge;
  int count = 0;
  cin >> cost;
  charge = 1000 - cost;
  for(int i = 0; i<6; )
    {
      if(charge - arr[i] >=0)
      {
        count ++;
        charge -= arr[i];
      }
      else
        i++;
    }
  cout << count;
}