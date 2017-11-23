/*
 ============================================================================
 Name        : Lista09Dupla.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

//Estrutura
struct dados {
	int codigo;
	struct dados *proximo;
	struct dados *anterior;
};

typedef struct dados dados;

//Protótipo
dados* inserirInicio(dados *lista);
dados* inserirFinal(dados *lista);
void imprimirRecursiva(dados *lista, int cont);
dados* excluirDados(dados *lista, int cod);

//Funções
int main(void) {
	setbuf(stdout, NULL);
	dados *listaDados;
	int i;

	//Criei lista nula
	listaDados = NULL;

	imprimirRecursiva(listaDados,0);

	//Inserir elementos na lista
	for (i = 0; i <= 3; i++){
		listaDados = inserirInicio(listaDados);
		//listaDados = inserirFinal(listaDados);
		//printf("\nCódigo %d e endereço do próximo %p",
		//			listaDados->codigo, listaDados->proximo);
	}

	imprimirRecursiva(listaDados,0);

	//Exclusões
	printf("\nExcluir o registro 3340\n");
	listaDados = excluirDados(listaDados, 3340);
	imprimirRecursiva(listaDados,0);

	printf("\nExcluir o registro 334\n");
	listaDados = excluirDados(listaDados, 334);
	imprimirRecursiva(listaDados,0);

	printf("\nExcluir o registro 41\n");
	listaDados = excluirDados(listaDados, 41);
	imprimirRecursiva(listaDados,0);

	printf("\nExcluir o registro 500\n");
	listaDados = excluirDados(listaDados, 500);
	imprimirRecursiva(listaDados,0);

	printf("\nExcluir o registro 467\n");
	listaDados = excluirDados(listaDados, 467);
	imprimirRecursiva(listaDados,0);

	return 0;
}

dados* inserirInicio(dados *lista){
	dados *novoAluno = (dados*) malloc (sizeof(dados));
	novoAluno->codigo = rand() % 1000;

	//Apontamentos
	novoAluno->anterior = NULL;
	novoAluno->proximo = lista;
	if (lista != NULL) {
		lista->anterior = novoAluno;
	}

	return novoAluno;
}

dados* inserirFinal(dados *lista){
	dados *novoAluno = (dados*) malloc (sizeof(dados));
	novoAluno->codigo = rand() % 1000;

	if (lista == NULL) {
		novoAluno->anterior = NULL;
		novoAluno->proximo = NULL;
		return novoAluno;
	} else {
		dados *tmp = lista;
		while (tmp->proximo != NULL) {
			tmp = tmp->proximo;
		}

		//Apontamentos
		tmp->proximo = novoAluno;
		novoAluno->anterior = tmp;
		novoAluno->proximo = NULL;
		return lista;
	}

}

void imprimirRecursiva(dados *lista, int cont){
	if (lista != NULL){
		printf("\nCódigo %d"
				" Endereço atual %p"
				" Endereço anterior %p\n"
				" Próximo endereço %p\n",
				lista->codigo, lista, lista->anterior, lista->proximo);
		imprimirRecursiva(lista->proximo, cont+1);
	} else if (cont == 0){
		printf("\nLista Vazia\n");
	}
}

dados* excluirDados(dados *lista, int cod){
	dados 	*atual = lista;

	while (atual != NULL){
		if (atual->codigo == cod){ //Encontrou o registro

		}
		atual = atual->proximo;
	}

	printf("\nRegistro não localizado.\n");
	return lista;

}
