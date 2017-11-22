		#include <stdio.h>
		#include <string.h>
		
	
		void SimOuNao (){
			
			
			char a [3];
			printf("Entre com : \n SIM = 1\n NAO = 0 \n");
			fflush(stdin);
			gets (a);
			
			scanf("%s",&a);
			
			
			if(strcmp (a,"SIM") == 0 || strcmp (a,"sim") == 0 ){
				
				printf("1");
			}
			
			else if (strcmp (a,"NAO") == 0 || strcmp (a,"nao") == 0){
				
				printf("0");
			}
			
			else{
				
				printf("String inserida invalida!");
			}
								
		}
				
		
		int main( ) 
		
		{
		
			
		SimOuNao();
		 	
		return(0);
		}
		
