/*
 ============================================================================
 Name        : Lista08.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

//Questão 01
int multiplicarSomando(int x, int y);
int multiplicarSomandoCauda(int x, int y, int parcial);

//Questão 02
void exibirTabuada(int n, int q);

//Questão 03
double calcularSerie(int n);
double calcularSerieCauda(int n, double parcial);

//Questão Extra
int potencia(int base, int expoente);

//Questão 04
int somarVetor(int *vet, int tam);
int somarVetorCauda (int *vet, int tam, int parcial);

//Questão 05
void baseBinaria(int n, int tam);

int main(void) {
	setbuf(stdout, NULL);

	//Questão 01
	printf("\nQuestão 01\n");
	printf("\nExercício 01 - 5 * 7 = %d (recursividade normal)\n", multiplicarSomando(5,7));
	printf("\nExercício 01 - 5 * 7 = %d (recursividade cauda)\n", multiplicarSomandoCauda(5, 7, 0));

	//Questão 02
	printf("\nQuestão 02\n");
	exibirTabuada(5, 6);
	//Não é possível fazer em cauda, não tem resultado parcial.

	//Questão 03
	printf("\nQuestão 03\n");
	printf("\nO cálculo da série é %.2lf (Recursividade normal)\n", calcularSerie(4));
	printf("\nO cálculo da série é %.2lf (Recursividade cauda)\n", calcularSerieCauda(4, 0));

	//Questão extra
	printf("\nQuestão Extra\n");
	printf("\nPotencia 2 ^ 5 = %d\n", potencia(2,5));

	//Questão 04
	printf("\nQuestão 04\n");
	int vet[] = {25, 9, 13, 18, 5};
	printf("\nA soma dos elementos é %d (Recursivo normal)\n", somarVetor(vet, 5));
	printf("\nA soma dos elementos é %d (Recursivo cauda)\n", somarVetorCauda(vet, 5, 0));

	//Questão 05
	printf("\nQuestão 05\n");
	printf("\nNúmero binário para o 65 = ");
	baseBinaria(65, 8);
	return 0;
}

//Questão 01
int multiplicarSomando(int x, int y){
	if (x == 1){
		return y;
	} else {
		return y + multiplicarSomando(x-1, y);
	}
}

int multiplicarSomandoCauda(int x, int y, int parcial){
	if (x == 0){
		return parcial;
	} else {
		return multiplicarSomandoCauda(x - 1, y, parcial + y);
	}
}

//Questão 02
void exibirTabuada(int n, int q){
	if (q == 1) {
		printf("\n%d * %d = %d\n", n, q, n * q);
	} else {
		exibirTabuada(n, q-1);
		printf("\n%d * %d = %d\n", n, q, n * q);
	}

	/* Outra solução para o mesmo exercício
	if (q != 1) {
		exibirTabuada(n, q-1);
	}
	printf("\n%d * %d = %d\n", n, q, n * q);
	*/
}

//Questão 03
double calcularSerie(int n){
	if (n == 1) {
		return pow(n, 3) / pow(10, n-1);
	} else {
		return pow(n, 3) / pow(10, n-1) + calcularSerie(n-1);
	}
}

double calcularSerieCauda(int n, double parcial){
	if (n == 1) {
		return parcial + pow(n, 3) / pow(10, n-1);
	} else {
		return calcularSerieCauda(n-1, parcial +
								  	    pow(n, 3) / pow(10, n-1));
	}
}

//Questão Extra
int potencia(int base, int expoente){
	if (expoente == 1) {
		return base;
	} else {
		return base * potencia(base, expoente - 1);
	}

}


//Questão 04
int somarVetor(int *vet, int tam){
	if (tam == 1) {
		return *vet;
	} else {
		return *vet + somarVetor(++vet, tam - 1);
		/*
		 vet++;
		 return *vet + somarVetor(vet, tam - 1);
		*/
	}
}

int somarVetorCauda (int *vet, int tam, int parcial) {
	if (tam == 1) {
		return parcial + *vet;
	} else {
		return somarVetorCauda(++vet, tam-1, parcial + *vet);
	}
}

//Questão 05
void baseBinaria(int n, int tam){
	if (tam == 1) {
		printf("%d", 0);
	}else {
		baseBinaria(n / 2, tam-1);
		printf("%d", n % 2);
	}
}



