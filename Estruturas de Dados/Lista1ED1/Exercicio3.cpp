	#include <stdio.h>
	#include <string.h>
	
	
	int main( ) 
	
	{
		
	 char nome [20];
	 char endereco [40];
	 char telefone [9];
	 char idade [2];
	 
	 
	printf("\n Insira o nome: ");
	fflush(stdin); 
	gets (nome);
	 
	 
	printf("\n Insira o endereco: ");
	fflush(stdin);
	gets (endereco);
	 
	printf("\n Insira o telefone: ");
	fflush(stdin);
	gets (telefone);
	
	printf("\n Insira a idade: ");
	fflush(stdin); 
	gets (idade);
	 
	printf("\n Seu Nome e: %s, Voce tem: %s anos, Mora na Rua:  %s e seu telefone e: %s", nome, idade,endereco,telefone);
	
	return(0);
	}
	
