/*
 ============================================================================
 Name        : recursividade.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int fatorial (int n);
int fibonacci(int termo);
int fibonacciCauda(int termo);
int fib (int termo, int ultimo, int penultimo);

int main(void) {
	setbuf(stdout, NULL);
	//printf("\nFatorial de 5 é %d\n", fatorial(5));
	//printf("\nFibonacci de 5 = %d", fibonacci(20));
	printf("\nFibonacci de 5 = %d", fibonacciCauda(5));
	//printf("\nFibonacci de 5 = %d", fib(5, 1, 0));
	return 0;
}

int fatorial (int n) {
	if (n <= 1)
		return 1;
	else
		return n * fatorial (n-1);
}

int fibonacci(int termo) {
	if (termo <= 1)
		return termo;
	else
		return fibonacci(termo-1) + fibonacci(termo-2);
}

int fib (int termo, int ultimo, int penultimo) {
	if (termo == 0)
		return penultimo;
	else
		return fib (termo -1, ultimo + penultimo, ultimo);
}

int fibonacciCauda(int termo){
	return fib(termo, 1, 0);
}

