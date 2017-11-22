	#include <stdio.h>
	#include <string.h>
	
		void CopiaString(){
			
	 char string [80];
	 char string2 [80] = "";
	 int tamanho = 0;
	 
	 
	 printf("\n Insira uma String: ");
	 
	 fflush(stdin);
	 gets(string);	
	 tamanho= strlen(string);
	
	 
	 
	 for (int contador = 0; contador<tamanho; contador++){
	 	
	 	
	 	string2 [contador] = string[contador];	 	
	 	
	}
	
	printf("\n String copiada: %s", string2);
}
	
	int main( ){
	
	CopiaString();
	
	return 0;
		
	}
