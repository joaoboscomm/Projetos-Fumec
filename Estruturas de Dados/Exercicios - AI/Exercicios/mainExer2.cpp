#include <stdio.h>
#include <string.h>


int main() {
	
	printf("\n \n \t *** EXERCICIO 02 - MANIPULACAO STRINGS! *** \n");
	
	
//Questao 1

	char prim[50], seg[50];
	
	printf("\n\t Entre com a primeira String: ");
	fflush(stdin);
	gets(prim);
	
	
	printf("\t Entre com a segunda String: ");
	fflush(stdin);
	gets(seg);


//Questao 2

	strcat (prim, " ");
	strcat (prim, seg);

//Questao 3


	if (strcmp(prim, seg) >= 0){
	printf("\n \t String 1: %s", prim);
	printf("\n \t String 2: %s", seg);
	}
	else{
	printf("\n \t String 1: %s", seg);
	printf("\n \t String 2: %s", prim);
	}


//Questao 4


	strcat(seg, prim);
	

//Questao 5

	 char find;
	 printf("\n \t Insira o caracter que deseja substituir: ");
	 fflush(stdin);
	 //gets(find);
	 scanf("%c", &find);
	
	
    for (int i = 0; i < strlen(prim); ++i) {
    	
        if (prim[i] == find ) {
        	
    			prim[i] = '*';
    			
		}
		
	        
    }
	
	
//Questao 6


	int tamanho = strlen(prim);
	printf("\n \n \t A string %s possui %d caracteres!", prim, tamanho);


//Questao 7

	int i = 0;
	int tamanhoSt2 = 0;
	
		
	while(seg[i] != 0){
	
	tamanhoSt2 ++; 
	i++;
	}
	
	printf("\n \t A String %s tem %d caracteres!", seg, tamanhoSt2);


return 0;
}
