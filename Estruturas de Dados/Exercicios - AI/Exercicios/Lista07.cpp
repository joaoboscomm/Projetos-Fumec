#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct produto{
	char descricao[40];
	int codigo;
	double preco;
	int quantidade;
};

//Novo tipo utilizando a estrutura anterior
typedef struct produto prod;

//Protótipo
void menu();
int validarInteiros();
prod* alocarEstrutura(int *tam);
int criarCodigo();
void inserirProduto(prod *listaProdutos, int indice);
void criarDescricao(char *frase);
void criarPreco(prod *ficha);

//Códigos
int main(void) {
	
	menu();
	return 0;
}

void menu(){
	int op,
	tamanho = 0,
	indice = 0;
	prod *produtos;

	do{
		printf("\n1 – Criar estrutura para preenchimento"
				"\n2 – Preencher dados"
				"\n3 – Exibir produtos com estoque zerado"
				"\n4 – Exibir produtos em estoque"
				"\n5 – Finalizar"
				"\nDigite sua opção: ");
		fflush(stdin);
		scanf("%d", &op);

		switch(op) {
		case 1:
			if (tamanho == 0) {
				produtos = alocarEstrutura(&tamanho);
			} else {
				printf("\nEstrutura já criada.");
			}
			break;
		case 2:
			if (tamanho > 0 && indice <= tamanho){
				inserirProduto(produtos, indice);
			} else if (tamanho == 0){
				printf("\nEstrutura não criada");
			} else {
				printf("\nTodos os produtos já foram cadastrados.");
			}
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			printf("\nPrograma finalizado");
			break;
		default:
			printf("\nOpção inválida.");
		}



	} while (op != 5);
}

int validarInteiros(){
	int numero;
	do{
		printf("\nDigite a quantidade de produtos: ");
		fflush(stdin);
		scanf("%d", &numero);

		if (numero <= 0){
			printf("\nValor inválido");
		}
	} while (numero <= 0);
	return numero;
}

prod* alocarEstrutura(int *tam){
	*tam = validarInteiros();
	prod *listaProd = (prod*) malloc (*tam * sizeof(prod));
	return listaProd;
}

void inserirProduto(prod *listaProdutos, int indice){
	listaProdutos[indice].codigo = criarCodigo();
	criarDescricao(listaProdutos[indice].descricao);
	printf("\n Entre com a posicao da ficha desejada:");
	criarPreco(&listaProdutos[indice]);
	
	
	printf("\n%d - %s - %lf - %d\n",
			listaProdutos[indice].codigo,
			listaProdutos[indice].descricao,
			listaProdutos[indice].preco,
			listaProdutos[indice].quantidade);
}

int criarCodigo(){
	int codigo;

	printf("\nDigite o código do produto: ");
	fflush(stdin);
	scanf("%d", &codigo);
	while (codigo < 0 || codigo > 50){
		printf("\nCódigo inválido. \nDigite o código do produto: ");
		fflush(stdin);
		scanf("%d", &codigo);
	}
	return codigo;
}

void criarDescricao (char *frase){
	
	frase[0] = '\0';
	
	while (frase[0] == '\0'){
		
			printf("\n Digite a descricao:");
			fflush(stdin);
			gets(frase);
		
	}

}

//receber uma ficha especifica
void criarPreco (prod *ficha){
	
	
while (ficha->preco < 0){
		printf("\nDigite o preço do %s R$", ficha->descricao);
		fflush(stdin);
		scanf("%lf", &(ficha)->preco);

		if (ficha->preco < 0) {
			printf("\nValor inválido.");
		}
	} 
	
	
	
}
