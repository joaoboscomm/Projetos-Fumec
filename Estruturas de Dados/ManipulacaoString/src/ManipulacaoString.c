/*
 ============================================================================
 Name        : ManipulacaoString.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <string.h>
#include <stdio.h>

int main() {
	setbuf(stdout, NULL);
	char nome[50], sobrenome[50];

	printf("\nDigite seu nome: ");
	fflush(stdin);
	gets(nome);


	printf("\nDigite seu sobrenome: ");
	fflush(stdin);
	gets(sobrenome);

	strcpy(nome, sobrenome);

	printf("\nO nome é %s.\n", nome);
	return 0;
}
