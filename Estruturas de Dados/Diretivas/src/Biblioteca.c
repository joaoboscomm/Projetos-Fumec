/*
 * Biblioteca.c
 *
 *  Created on: 16 de out de 2017
 *      Author: amanda.oliveira
 */


int soma(int a, int b){
	return a + b;
}

int sub(int a, int b){
	return a - b;
}

int multi(int a, int b){
	return a * b;
}

void imprima(int a, int b, int (*pFunc) (int, int)){
	printf("\nO resultado é %d", pFunc(a,b));
}
