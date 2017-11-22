#include <stdio.h>
#include <string.h>


int main() {
	
	//Questao 1
	char prim[50], seg[50];
	
	printf("\t Entre com a primeira String: ");
	fflush(stdin);
	gets(prim);
	
	printf("\t Entre com a segunda String: ");
	fflush(stdin);
	gets(seg);
	
	//Questao 2
	strcat (prim, " ");
	strcat (prim, seg);
	
	//Questao 3
	tolower(prim);
	tolower(seg);
	
	if (strcmp(prim, seg) >= 0){
		
		printf("%s", prim);
		printf("%s", seg);
	}
	
	else{
		
		printf("%s", seg);
		printf("%s", prim);
	}
	
	//Questao 4
	strcat(seg, prim);
	
	//Questao 5
	char find;
	
	printf("\t Insira o caracter que deseja procurar: ");
	fflush(stdin);
	gets(find);
	
	
	while (strchr(prim, find) == 0){
		
		int conta;
		conta ++;
		
	}
	
	prim[conta] == "*";
	
	
	//Questao 6
	
	int tamanho = strlen(prim);
	printf("\t A string %s possui %d caracteres!", prim, tamanho);
	
	
	//Questao 7
	
	int i = 0;
	
	while(seg[i] != null){
		
		int tamanhoSt2 = 0;
		tamanhoSt2 ++;		
		
		}
	
	printf("\t A String %s tem %d caracteres!", seg, tamanhoSt2);
	
	
	
	return 0;
	
	
}
