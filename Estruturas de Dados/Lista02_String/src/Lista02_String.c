/*
 ============================================================================
 Name        : Lista02_String.c
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
	setbuf(stdout, NULL);

	char 	str[50],
			str2[50],
			caractere;

	int 	i;

	//Primeiro exercício
	printf("\n--------------------------------------\n");
	printf("\nReceber duas strings");

	printf("\nDigite a primeira string: ");
	fflush(stdin);
	gets(str);

	printf("\nDigite a segunda string: ");
	fflush(stdin);
	gets(str2);

	printf("\nPrimeira String %s \nSegunda String %s.", str, str2);

	//Segundo exercício
	printf("\n--------------------------------------\n");
	printf("\nConcatenar a segunda dentro da primeira");
	strcat(str, " ");
	strcat(str, str2);
	printf("\nPrimeira String %s \nSegunda String %s.", str, str2);

	//Terceira exercício
	printf("\n--------------------------------------\n");
	printf("\nExibir em ordem alfabética");
	if (strcmp(str, str2) == -1) {
		printf("\n%s \n%s", str, str2);
	} else {
		printf("\n%s \n%s", str2, str);
	}

	//Quarto exercício
	printf("\n--------------------------------------\n");
	printf("\nSubstituir a segunda pela primeira");
	strcpy(str2, str);
	printf("\nPrimeira String %s \nSegunda String %s.", str, str2);

	//Quinto exercício
	printf("\n--------------------------------------\n");
	printf("\nSubstituir um caractere dentro da string1");

	printf("\nDigite o caractere a ser substuído: ");
	fflush(stdin);
	scanf("%c", &caractere);

	for(i = 0; str[i] != '\0'; i++){
	//for(i = 0; str[i]; i++){
		if (str[i] == caractere){
			str[i] = '*';
		}
	}
	printf("\nPrimeira String %s.", str);

	//Sexto exercício
	printf("\n--------------------------------------\n");
	printf("\nA string %s possui %i caracteres.", str, strlen(str));

	//Sétimo exercício
	printf("\n--------------------------------------\n");
	for(i = 0; str[i] != '\0'; i++);
	//for(i = 0; str[i]; i++);

	printf("\nA string %s possui %i caracteres.", str, i);

	return 0;
}
