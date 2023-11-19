#include <iostream>
using namespace std;
int main() {
	int money;
	int number;
	cin >> money;
	cin >> number;
	int sum = 0;

	for (int i = 0; i < number; i++) {
		int price;
		int n;
		cin >> price >> n;
		sum = sum + n * price;
	}
	if (sum == money) {
		cout << "Yes";
	}
	else if (sum != money){
		cout << "No";
	}
} 