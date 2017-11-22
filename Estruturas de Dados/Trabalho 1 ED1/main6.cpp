	#include <stdio.h>
	#include <string.h>
	
	void Copiar(){
		
	 int tamanho = 0;
	 char string [tamanho];
	 char string2 [tamanho];
	 int contador = 0;
	 
	 
	 printf("Insira uma String para ser copiada:");
	 
	 fflush(stdin);
	 gets(string);	
	 tamanho= strlen(string);
		
		 for (contador; contador<tamanho; contador++){
	 	
	 	string2[contador] = string[contador];
	 	
	}
	
	printf("String copiada: %s", string2);
	
	
}

	int main( ) {
	
	
	{		
	  
	 Copiar();
		 	
	 	
	 }
	
	return (0);
	
	}
	

	
	

