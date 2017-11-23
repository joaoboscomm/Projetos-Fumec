/*
 * Biblioteca.h
 *
 *  Created on: 16 de out de 2017
 *      Author: amanda.oliveira
 */

#ifndef BIBLIOTECA_H_
#define BIBLIOTECA_H_

int soma(int a, int b);
int sub(int a, int b);
int multi(int a, int b);
void imprima(int a, int b, int (*pFunc) (int, int));

struct calc {
	int (*soma) (int, int);
	int (*sub) (int, int);
	int (*multi) (int, int);
};

typedef struct calc calc;

struct operacoes{
	int op1;
	char op;
	int op2;
	double resultado;
};

typedef struct operacoes operacoes;

#endif /* BIBLIOTECA_H_ */
