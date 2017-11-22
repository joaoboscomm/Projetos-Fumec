		#include <stdio.h>
		#include <string.h>
		
	
		void Soletra ( String a ){
			
			for (int contador = 0; contador<tamanho; contador++){
	 	
	 	
			if(strcmp (a[contador],"0") == 0){
				
				printf(" Zero ");
			}
			
			if(strcmp (a[contador],"1") == 0){
				
				printf(" Um ");
			}
			
				if(strcmp (a[contador],"2") == 0){
				
				printf(" Dois ");
			}
			
				if(strcmp (a[contador],"3") == 0){
				
				printf(" Tres ");
			}
			
				if(strcmp (a[contador],"4") == 0){
				
				printf(" Quatro ");
			}
			
				if(strcmp (a[contador],"5") == 0){
				
				printf(" Cinco ");
			}
			
				if(strcmp (a[contador],"6") == 0){
				
				printf(" Seis ");
			}
			
				if(strcmp (a[contador],"7") == 0){
				
				printf(" Sete ");
			}
			
				if(strcmp (a[contador],"8") == 0){
				
				printf(" Oito ");
			}
			
				if(strcmp (a[contador],"9") == 0){
				
				printf(" Nove ");
			}
			
			else{
				
				return(printf(" "));
			}
								
		}
				
	}
		int main( ) 
		
		{
			char a [3];
			
			printf("Entre com o numero a ser soletrado");
			fflush(stdin)
			gets (a);
			
			scanf("%s",&a)
			
			printf("\n Numero soletrado:  %d" , Soletra(a));
		 	
		return(0);
		}
		
