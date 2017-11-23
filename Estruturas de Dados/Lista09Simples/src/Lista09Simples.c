/*
 ============================================================================
 Name        : Lista09.c
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
};

typedef struct dados dados;

//Protótipo
dados* criarNulo(dados *lista);
dados* inserirInicio(dados *lista);
void imprimirRecursiva(dados *lista);
dados* inserirFinal(dados *lista);
dados* excluirDados(dados *lista, int cod);

//Funções
int main(void) {
	setbuf(stdout, NULL);
	dados *listaDados;
	int i;

	//Criei lista nula
	listaDados = criarNulo(listaDados);

	//Inserir elementos na lista
	for (i = 0; i <= 3; i++){
		listaDados = inserirInicio(listaDados);
		listaDados = inserirFinal(listaDados);
		//printf("\nCódigo %d e endereço do próximo %p",
		//			listaDados->codigo, listaDados->proximo);
	}

	imprimirRecursiva(listaDados);

	//Exclusões
	printf("\nExcluir o registro 3340\n");
	listaDados = excluirDados(listaDados, 3340);
	imprimirRecursiva(listaDados);

	printf("\nExcluir o registro 334\n");
	listaDados = excluirDados(listaDados, 334);
	imprimirRecursiva(listaDados);

	printf("\nExcluir o registro 41\n");
	listaDados = excluirDados(listaDados, 41);
	imprimirRecursiva(listaDados);

	printf("\nExcluir o registro 500\n");
	listaDados = excluirDados(listaDados, 500);
	imprimirRecursiva(listaDados);

	printf("\nExcluir o registro 467\n");
	listaDados = excluirDados(listaDados, 467);
	imprimirRecursiva(listaDados);

	return 0;
}

dados* criarNulo(dados *lista){
	return NULL;
}


dados* inserirInicio(dados *lista){
	dados *novoAluno = (dados*) malloc (sizeof(dados));
	novoAluno->codigo = rand() % 1000;
	novoAluno->proximo = lista;
	return novoAluno;
}

dados* inserirFinal(dados *lista){
	dados *novoAluno = (dados*) malloc (sizeof(dados));
	novoAluno->codigo = rand() % 1000;
	novoAluno->proximo = NULL;

	if (lista == NULL) {
		return novoAluno;
	} else {
		dados *tmp = lista;
		while (tmp->proximo != NULL) {
			tmp = tmp->proximo;
		}

		tmp->proximo = novoAluno;
		return lista;
	}

}

void imprimirRecursiva(dados *lista){
	if (lista != NULL){
		printf("\nCódigo %d"
				"\nEndereço atual %p"
				"\nPróximo endereço %p\n",
				lista->codigo, lista, lista->proximo);
		imprimirRecursiva(lista->proximo);
	}
}

dados* excluirDados(dados *lista, int cod){
	dados 	*atual = lista,
			*anterior = NULL;

	while (atual != NULL){
		if (atual->codigo == cod){ //Encontrou o registro
			if (anterior == NULL){
				anterior = atual->proximo;
				free(atual);
				return anterior;
			} else {
				anterior->proximo = atual->proximo;
				free(atual);
				return lista;
			}
		}
		anterior = atual;
		atual = atual->proximo;
	}

	printf("\nRegistro não localizado.\n");
	return lista;

}










