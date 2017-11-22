#include <stdio.h>
#include <string.h>


	void SimOuNao (){
		
		
		char a [4];
		printf("\n Digite: \n");
		
		fflush(stdin);
		gets(a);
			
		
	
		
		if(strcmp (a, "SIM") == 0 || strcmp (a, "sim") == 0){

			printf("\n Retorno = 1");
		
		}


		else if (strcmp (a, "NAO") == 0|| strcmp (a, "nao") == 0){
			
				printf("\n Retorno = 0");
				
		
		}
	
	
		else{


			printf("Entrada invalida!");
			
		}
}

	int main( ){
		
		SimOuNao();
	
		return(0);
}
