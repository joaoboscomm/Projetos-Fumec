/*
 ============================================================================
 Name        : Funcoes.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

//Protótipos
int somarNumeros(int a, int b);
void mensagem();
void somarElementos(int *pVet, int tam, int *soma);
//double dividir(int, int);


int main(void) {
	int soma, vet[] = {15, 25, 65, 78};
	somarElementos(vet, 4, &soma);
	printf("\nA soma dos elementos é %d\n", soma);

	/*int a = 15, b = 85;
	printf("\n%d\n", somarNumeros(b, a)); */
	return 0;
}

int somarNumeros(int a, int b){
	mensagem();
	return a + b;
}

void mensagem(){
	printf("\nIniciando a soma\n");
}

void somarElementos(int *pVet, int tam, int *soma){
	int i;
	*soma = 0;
	for (i = 0; i < tam; i++){
		*soma += *pVet;
		pVet++;
	}
}

