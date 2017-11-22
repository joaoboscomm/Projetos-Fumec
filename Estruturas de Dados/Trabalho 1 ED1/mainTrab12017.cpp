#include <stdio.h>


void exchange (int a, int b);

int main() {
	
	int n = 5,
		a = 0,
		b,
		c;
		
		for (b=1; b<=n ; b++){
			
			for (c=b ; c<= n; c++){
				
				a++;
			}
		}
	
	printf("\n%d\n", a);
	return 0;
}


