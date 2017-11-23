/*
 ============================================================================
 Name        : Lista03_Ponteiros.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	/*

	 int x, *px;

	px = &x;

	scanf("%d", &x);
	scanf("%d", px);
	 */
	int j, *pj;
	pj = &j;

	printf("\n%i - %p\n", j, &j);
	*pj = 3;
	printf("\n%i - %p\n", *pj, pj);


	return 0;
}
