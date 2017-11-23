/*
 ============================================================================
 Name        : NovasEstruturas.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

union dados {
	int valI;
	float valF;
};

typedef union dados Dados;

int main(void) {

	Dados teste;

	teste.valI = 23;
	printf("\n%d", teste.valI);

	teste.valF = teste.valI * 2.5;
	printf("\n%f", teste.valF);


	return 0;
}

