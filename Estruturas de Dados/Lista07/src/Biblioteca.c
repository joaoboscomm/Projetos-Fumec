/*
 * Biblioteca.c
 *
 *  Created on: 23 de out de 2017
 *      Author: amanda.oliveira
 */


int soma(int termo1, int termo2){
	return termo1 + termo2;
}

int subtracao(int termo1, int termo2){
	return termo1 - termo2;
}

int multiplica(int termo1, int termo2){
	return termo1 * termo2;
}

double divisao(int termo1, int termo2){
	return (double) termo1 / termo2;
}

int fatorial(int termo1) {
	int i, fat = 1;
	for (i = 2; i <= termo1; i++) {
		fat *= i;
	}
	return fat;

	/*
		int fat = 1;
		for (; termo1 >= 2; termo1--) {
			fat *= termo1;
		}
		return fat;

	 */
}
