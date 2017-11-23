/*
 ============================================================================
 Name        : Lista01_Nivelamento.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(void) {
	setbuf(stdout, NULL);

	//Declaração de variáveis
	char 	op;
	int 	termos,
			numero;
	double	resultado;


	//Loop para toda a lógica
	for(;;) {
		do{
			printf("\nA - Calcular a série A"
					"\nB - Calcular a série B"
					"\nC - Calcular a série C"
					"\nD - Finalizar digitação"
					"\nDigite sua opção: ");
			fflush(stdin);
			scanf("%c", &op);

			if (op < 'A' || op > 'D') {
				printf("\nInválido. Digite novamente.");
			}
		} while (op < 'A' || op > 'D'); //Validar para ser de A até D

		if (op == 'D'){ //Finalizar
			printf("\nPrograma finalizado.");
			break;
		} else {
			//Solicitar termos
			printf("\nDigite a quantidade de termos a ser calculada: ");
			fflush(stdin);
			scanf("%d", &termos);

			//Validar para só receber positivos
			while (termos <= 0) {
				printf("\nValor inválido. Digite a quantidade de termos a ser calculada: ");
				fflush(stdin);
				scanf("%d", &termos);
			}

			//Inicialização de variáveis
			resultado = 0;
			numero = 1;

			//Calcular as séries
			switch (op) {
			case 'A' : //Série A
						while (termos > 0) {
							resultado += (double) (numero + (numero - 1)) / pow(numero, 2);
							numero++;
							termos--;
						}


						break;

			case 'B': //Série B
						do{
							resultado += (double) pow(numero, 3) / pow(10, numero - 1);
							numero++;
							termos--;
						} while (termos > 0);

						break;
			case 'C': //Série C
						for(; termos > 0; termos--){
							resultado += (double) numero / (3 * (numero * 2));
							numero++;
						}
						break;
			} //Finaliza o switch

			//Exibir resultado final
			printf("\nO resultado é %.2lf\n", resultado);
		} //Finaliza o else
	} //Finaliza o for

	return 0;
}
