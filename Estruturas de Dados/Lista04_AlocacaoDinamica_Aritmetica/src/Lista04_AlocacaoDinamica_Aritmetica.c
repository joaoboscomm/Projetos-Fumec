/*
 ============================================================================
 Name        : Lista04_AlocacaoDinamica_Aritmetica.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	setbuf(stdout, NULL);

	int *pVetor,
		tam,
		i,
		soma = 0;

	//Solicitar o tamanho do vetor
	do {
		printf("\nDigite o tamanho do vetor: ");
		fflush(stdin);
		scanf("%i", &tam);
	} while (tam <= 0);

	//Alocação dinâmica
	pVetor = (int *) malloc (tam * sizeof(int));

	//Preencher o vetor alocado
	for (i = 0; i < tam; i++) {
		do{
			printf("\nDigite o valor da %iª posição:", i+1);
			fflush(stdin);
			scanf("%i", pVetor);

			if (*pVetor < 0) {
				printf("\nValor inválido.");
			}
		} while (*pVetor < 0);

		pVetor++;
	}

	//Voltar o ponteiro para índice 0
	pVetor -= tam;

	for(i = 0; i < tam; i++) {
		if ( i % 2 == 0){
			*pVetor *= 2; //*pVetor = *pVetor * 2;
		} else {
			*pVetor /= 2; //*pVetor = *pVetor / 2;
		}

		printf("\nPosição %d - Valor %d", i+1, *pVetor);
		soma += *pVetor; //soma = soma + *pVetor;
		pVetor++;
	}

	printf("\nSoma dos elementos %i", soma);

	//Voltar o ponteiro para índice 0
	pVetor -= tam;
	free(pVetor);

	return 0;
}
