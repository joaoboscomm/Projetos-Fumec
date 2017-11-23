/*
 ============================================================================
 Name        : Aula01.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>

int main(void) {
	setbuf(stdout, NULL); //Limpar o buffer de vídeo

	int x;

	double y;

	x = 45;
	y = x++;

	//imprimir só texto
	printf("Testando 1 2 3\n");

	//imprimir só variável
	printf("%d", x);

	//imprimir texto e variável
	printf("\nA variável x possui valor = %d e y = %.2f", x, y);

	//Inclusão de valor em x
	printf("\nDigite o valor de x: ");
	scanf("%d", &x);

	//Operador ternário
	if (x > 15) {
		y = 19;
	} else {
		y = 12;
	}

	y = x > 15 ? 19 : 12;  //Operador ternário para o if anterior
	printf("\nO valor de y é %lf", y);

	if (x % 2 == 0) {
		printf("\nPar");
	} else {
		printf("\nÍmpar");
	}

	x % 2 == 0 ? printf("\nPar") : printf("\nÍmpar"); //Operador ternário para o if anterior



	char op;
	printf("\nOpção: ");
	fflush(stdin); //Limpar o ponteiro para a digitação
	scanf("%c", &op);




	return 0;
}
