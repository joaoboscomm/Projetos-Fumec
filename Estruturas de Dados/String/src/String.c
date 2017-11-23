/*
 ============================================================================
 Name        : String.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void) {
	//	char letra = 'A';
	//
	//	printf("\nA letra é %c e seu correspondente numérico é %d", letra, letra);

	char nome[50];
	int tamanho;

	printf("\nDigite seu nome: ");
	fflush(stdin);
	gets(nome);

	tamanho = strlen(nome);
	printf("\nO nome %s possui %d caracteres.\n", nome, tamanho);
	return 0;
}
