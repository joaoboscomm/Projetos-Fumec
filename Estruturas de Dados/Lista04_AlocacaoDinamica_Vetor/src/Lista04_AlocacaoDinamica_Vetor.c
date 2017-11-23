/*
 ============================================================================
 Name        : Lista04_AlocacaoDinamica_Vetor.c
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

	for(i = 0; i < tam; i++){
		do{
			printf("\nDigite o valor da %dª posição: ", i+1);
			fflush(stdin);
			scanf("%i", &pVetor[i]);

			if (pVetor[i] < 0){
				printf("\nValor inválido");
			}
		} while (pVetor[i] < 0);
	}

	for (i = 0; i < tam; i++) {
		if (i % 2 == 0){
			pVetor[i] *= 2;
		} else {
			pVetor[i] /= 2;
		}

		soma += pVetor[i];
		printf("\nPosição %d - Valor %d", i+1, pVetor[i]);
	}

	printf("\nSoma dos elementos %i", soma);
	free(pVetor);
	return 0;
}
