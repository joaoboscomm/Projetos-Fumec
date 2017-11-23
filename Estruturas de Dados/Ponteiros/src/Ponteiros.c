/*
 ============================================================================
 Name        : Ponteiros.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	/* Variável vetor
	double 	salario[5] = {1500, 560, 7898, 4523, 963},
			*pontSalario;

	pontSalario = salario;

	printf("\n%.2lf\n", *pontSalario);

	pontSalario++;
	printf("\n%.2lf\n", *pontSalario);

	(*pontSalario)++;
	printf("\n%.2lf\n", *pontSalario);

	*/
	/* Variável comum */
	int idade = 23;
	int *pontIdade = &idade;

	printf("\nEndereço de memória de idade (direto) %p\n", &idade);
	printf("\nEndereço de memória de idade (indireto) %p\n", pontIdade);
	printf("\nEndereço de memória de pontIdade  %p\n", &pontIdade);

	printf("\nConteúdo da variável idade (direto) %i\n", idade);
	printf("\nConteúdo da variável idade (indireto) %i\n", *pontIdade);


	return 0;
}
