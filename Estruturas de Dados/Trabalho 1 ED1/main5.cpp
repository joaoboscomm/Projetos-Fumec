	#include <stdio.h>
	#include <string.h>
	
	
	int main( ) 
	
	{
		
	 char string [80];
	 int tamanho = 0;
	 int contador = 0;
	 int palavras = 1;
	 
	 
	 
	 printf("Insira uma String:");
	 
	 fflush(stdin);
	 gets(string);	
	 tamanho= strlen(string);
	 
	 
	 for (contador; contador<tamanho; contador++){
	 	
	 	
	 	if(string [contador] == ' '){
	 		
	 		string [contador] = '\n';
	 		 palavras ++;
	 		  		
		 }
	 	
	 	
	 	
	 }
	
	
	printf(" \n  Numero de palavras: \n  \n%d", palavras);
	
	return 0;
		
	}
