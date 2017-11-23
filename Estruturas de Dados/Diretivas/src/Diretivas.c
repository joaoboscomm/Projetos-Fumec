/*
 ============================================================================
 Name        : Diretivas.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include "Biblioteca.h"

int main(void) {

	calc calculadora = {.soma = soma, .sub = sub, .multi = multi};

	operacoes *ops = (operacoes*) malloc (5 * sizeof(operacoes));

	ops[0].op1 = 2;
	ops[0].op = '+';
	ops[0].op2 = 2;
	ops[0].resultado = calculadora.soma(ops[0].op1, ops[0].op2);

	printf("\nO resultado da multiplicação é %d", calculadora.soma(2,9));
	return 0;
}

