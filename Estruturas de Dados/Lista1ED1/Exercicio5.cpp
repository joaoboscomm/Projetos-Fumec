	#include <stdio.h>
	#include <string.h>
	
		void ContaPalavras(){
			
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
	
	printf("\n Numero de palavras: %d", palavras);
}
	
	int main( ){
	
	ContaPalavras()
	;
	
	return 0;
		
	}
