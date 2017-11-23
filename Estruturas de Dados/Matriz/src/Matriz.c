/*
 ============================================================================
 Name        : Matriz.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	//	int vetor[2] = {15, 6};
	//	int vetor2[] = {56, 12, 45, 9};

	int vet[20];
	int i, count;
	count=1;
	for(i = 0; i < 20; i++) {
		vet[i] = count++;
		//count++;
		printf("\n%d", vet[i]);
	}


	return 0;
}
