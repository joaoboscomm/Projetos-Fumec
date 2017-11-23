/*
 * Biblioteca.h
 *
 *  Created on: 23 de out de 2017
 *      Author: amanda.oliveira
 */

#ifndef BIBLIOTECA_H_
#define BIBLIOTECA_H_

#define TAM 5

//Protótipos
int soma(int termo1, int termo2);
int subtracao(int termo1, int termo2);
int multiplica(int, int);
double divisao(int termo1, int termo2);
int fatorial(int termo1);

//Estruturas
struct ponteiros{
	int (*soma) (int, int);
	int (*subtracao) (int, int);
	int (*multiplica) (int, int);
	double (*divisao) (int, int);
	int (*fatorial) (int);
};

typedef struct ponteiros calculadora;

calculadora calc = {.soma = soma, .subtracao = subtracao, .multiplica = multiplica, .divisao = divisao, .fatorial = fatorial};


struct calculos{
	int termo1;
	char tipo;
	int termo2;
	double resultado;
};

typedef struct calculos memoria;

#endif /* BIBLIOTECA_H_ */
