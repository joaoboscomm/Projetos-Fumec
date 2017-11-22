#include <stdio.h>
#include <string.h>


	void Soletra (){
		
		
		char string [80];
		int tamanho;
		
		printf("\n Digite o numero a ser soletrado: \n");
		
		fflush(stdin);
		gets(string);
		tamanho= strlen(string);
			
		
	for (int contador = 0; contador<tamanho; contador++){
		
	
		
		if(string[contador] == '0'){

			printf("\n Zero ");
		
		}

		else if(string[contador] == '1'){
		
					printf("\n Um ");
				
				}
		
		else if(string[contador] == '2'){
		
					printf("\n Dois ");
				
				}
		
		else if(string[contador] == '3'){
		
					printf("\n Tres ");
				
				}
		
		else if(string[contador] == '4'){
		
					printf("\n Quatro ");
				
				}
		
		else if(string[contador] == '5'){
		
					printf("\n Cinco ");
				
				}
		
		else if(string[contador] == '6'){
		
					printf("\n Seis ");
				
				}
		
		else if(string[contador] == '7'){
		
					printf("\n Sete ");
				
				}
		
		else if(string[contador] == '8'){
		
					printf("\n Oito ");
				
				}
		
		else if(string[contador] == '9'){
		
					printf("\n Nove ");
				
				}

		else{


			printf("Valor invalido!");
			
		}
		
	}
}

	int main( ){
		
		Soletra();
	
		return(0);
}
