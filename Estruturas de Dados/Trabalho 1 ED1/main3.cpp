	#include <stdio.h>
	#include <string.h>
	
	
	int main( ) 
	
	{
		
	 char nome [20];
	 char endereco [40];
	 char telefone [9];
	 char idade [2];
	 
	 
	printf("\nInsira o nome: ");
	fflush(stdin); 
	gets (nome);
	 
	 
	printf("\nInsira o endereco: ");
	fflush(stdin);
	gets (endereco);
	 
	printf("\nInsira o telefone: ");
	fflush(stdin);
	gets (telefone);
	
	printf("\nInsira a idade:");
	fflush(stdin); 
	gets (idade);
	 
	printf("\n Nome : %s \n Endereco: %s \n Telefone: %s \n Idade: %s \n", nome,endereco,telefone,idade);
	
	
	return(0);
	}
	
	
