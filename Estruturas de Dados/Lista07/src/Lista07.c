/*
 ============================================================================
 Name        : Lista07.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include "Biblioteca.h"

void menu();
int digitarNumero(char *frase);

int main(void) {
	setbuf(stdout, NULL);
	menu();
	return 0;
}

void menu(){
	int i,
		op,
		controle = -1;

	memoria *operacoes = (memoria*) malloc (TAM * sizeof(memoria));

	do{
		printf("\n1 - Somar dois valores"
				"\n2 - Subtrair dois valores"
				"\n3 - Multiplicar dois valores"
				"\n4 - Dividir dois valores"
				"\n5 - Calcular fatorial"
				"\n6 - Imprimir memória de cálculos"
				"\n7 - Finalizar"
				"\nDigite sua opção: ");
		fflush(stdin);
		scanf("%d", &op);

		switch (op) {
			case 1:
				controle++;
				operacoes[controle].termo1 = digitarNumero("Digite o primeiro número: ");
				operacoes[controle].termo2 = digitarNumero("Digite o segundo número: ");
				operacoes[controle].tipo = '+';
				operacoes[controle].resultado = calc.soma(operacoes[controle].termo1,
														  operacoes[controle].termo2);
				printf("\nO resultado da soma é %.0lf", operacoes[controle].resultado);
				break;
			case 2:
				controle++;
				operacoes[controle].termo1 = digitarNumero("Digite o primeiro número: ");
				operacoes[controle].termo2 = digitarNumero("Digite o segundo número: ");
				operacoes[controle].tipo = '-';
				operacoes[controle].resultado = calc.subtracao(operacoes[controle].termo1,
														       operacoes[controle].termo2);
				printf("\nO resultado da subtração é %.0lf", operacoes[controle].resultado);
				break;
			case 3:
				controle++;
				operacoes[controle].termo1 = digitarNumero("Digite o primeiro número: ");
				operacoes[controle].termo2 = digitarNumero("Digite o segundo número: ");
				operacoes[controle].tipo = '*';
				operacoes[controle].resultado = calc.multiplica(operacoes[controle].termo1,
														        operacoes[controle].termo2);
				printf("\nO resultado da multiplicação é %.0lf", operacoes[controle].resultado);
				break;
			case 4:
				controle++;
				operacoes[controle].termo1 = digitarNumero("Digite o primeiro número: ");
				operacoes[controle].termo2 = digitarNumero("Digite o segundo número: ");
				while (operacoes[controle].termo2 == 0) {
					printf("\nNão existe divisão por zero.");
					operacoes[controle].termo2 = digitarNumero("Digite o segundo número: ");
				}
				operacoes[controle].tipo = '/';
				operacoes[controle].resultado = calc.divisao(operacoes[controle].termo1,
														        operacoes[controle].termo2);
				printf("\nO resultado da divisao é %.2lf", operacoes[controle].resultado);
				break;
			case 5:
				controle++;
				operacoes[controle].termo1 = digitarNumero("Digite o primeiro número: ");
				while (operacoes[controle].termo1 < 0) {
					printf("\nNão existe fatorial de números negativos.");
					operacoes[controle].termo1 = digitarNumero("Digite o segundo número: ");
				}
				operacoes[controle].tipo = '!';
				operacoes[controle].resultado = calc.fatorial(operacoes[controle].termo1);
				printf("\nO resultado do fatorial é %.0lf", operacoes[controle].resultado);
				break;
			case 6:
				for (i = 0; i <= controle; i++) {
					if (operacoes[i].tipo != '!') {
						printf("\n%d %c %d = %.2lf", operacoes[i].termo1,
													 operacoes[i].tipo,
													 operacoes[i].termo2,
													 operacoes[i].resultado);
					} else {
						printf("\n%d %c = %.0lf", operacoes[i].termo1,
													 operacoes[i].tipo,
													 operacoes[i].resultado);

					}
				}
				break;
			case 7:
				printf("\nPrograma finalizado.");
				break;
			default:
				printf("\nValor inválido");
				break;
		}

		if (controle == 4) {
			break;
		}
	} while (op != 7);
}

int digitarNumero(char *frase){
	int numero;
	printf("\n%s", frase);
	fflush(stdin);
	scanf("%d", &numero);
	return numero;
}


