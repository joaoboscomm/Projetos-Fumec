	#include <stdio.h>
	#include <string.h>
	
	
	int main( ) 
	
	{
		
	 char string [80];
	 int tamanho = 0;
	 int contador = 0;
	 
	 
	 
	 printf("\n Insira uma String: ");
	 
	 fflush(stdin);
	 gets(string);	
	 tamanho= strlen(string);
	 
	 
	 for (contador; contador<tamanho; contador++){
	 	
	 	
	 	if(string [contador] == ' '){
	 		
	 		string [contador] = ' \n';
	 		
		 }
	 	
	 	
	 }
	
	
	printf(" \n  Segue as Strings Separadamente: \n%s", string);
	
	return 0;
		
	}