#include <stdio.h>
#include <string.h>
#include <stdlib.h>

double verificaRealPositivo(){
 	
 	double x;
 	printf("\n\t Insira um numero:");
 	fflush(stdin);
	scanf("%f", &x);
 	
 	if(x <= 0){
 		
 		printf("\n\t Numero inserido negativo ou nulo!");
	 }
	 
	 else{
	 	
	 	return x;
	 }
 	
 }

  char verificarTriangulo(double a, double b, double c){

 		double maior; 	
 		double check;
  		
  		
  		if (b > a){
  			
  			maior = b;
  			
  			check = a+c;
  			
  			//Verificar se lado c é maior
  			if (c > b){
  				
  				maior = c;
			  
			  	check = a+b;
			  	
			  	//se nao for triangulo
			  	if  (check < c){
			  		
			  		return 'N';
			  		
				  }
				  
				//se for triangulo  
				else{
					
				//verifica isoceles	
					if (a == c){
						
						return 'I';
					}
					//verifica escaleno	
					else if (a != b != c){
						
						return 'S';
					}
				//equilatero
					else if(a == b && b == c){
			
					return 'E';
		 
					}	
					
				}
				  
			}
			
			//se nao for triangulo
			else {
								
				if (check < b){
				
				return 'N';
				}
			
				else{
				
				//verifica isoceles	
					if (a == c){
						
						return 'I';
					}
					//verifica escaleno	
					else if (a != b != c){
						
						return 'S';
					}
				//equilatero
					else if(a == b && b == c){
			
					return 'E';
		 
					}	
				
				}
  			}
		}
  				  
		else if (c > a){
			
			maior = c;			
			
			check = a+b;
			
			//se é triangulo
			if (check < c){
				
				return 'N';
			}
			
			else{
					
					//isoceles
					if (a == b){
						
						return 'I';
					}
					
					//verifica escaleno	
					else if (a != b != c){
						
						return 'S';
					}
				//equilatero
					else if(a == b && b == c){
			
					return 'E';
		 
					}	
				
				}
		}
		
		
		
	}
		
		
	 int valida0a10(){
	 	
	 	int x;
 		printf("\n\t Insira um numero:");
 		fflush(stdin);
		scanf("%i", &x);
		
		if (x>=0 || x <=10){
			
		return x;

		}
	 	
	 	else{
	 		
	 		printf("\n \t Valor invalido!");
		 }
	 	
	 }
	 
	 //exercicio 5
	 void tabuada(int x ,int *vetor){
	 	
	  		 	
	  	printf("\n\n \t   *** TABUADA *** \n\n ");
		   	
	 	for (int i = 0; i <=10 ; i++){
	 		
	 		*vetor =  x*i;
	 		printf("\n \t %i x %i = %i \n", x, i, *vetor);
	 			 		
	 		vetor++;
	 		
		 }
		 		 
		 
	 }
  	
  	//exercicio 6
  	void resultTabuada(int *vetor){
  		
  		printf("\n\n \t *** IMPRESSAO DE VALORES ***\n\n ");
  		
  		for (int i = 0; i <= 10 ; i++){
  		
		  printf("\n\t Valor %i = %d \n", i, *vetor);	
		  
		  vetor ++;
  			
  		}
  		
	  }
	  	  
	  //exercicio 7
	  void copiaString(char *x, char *y){
	  	 
		// string x - destino
		// string y - origem
		
		int tamanho = strlen(y);
			
		for (char i = 0; i < tamanho ; i++){
			
			*x = *y;
			x++;
			y++;			
		}
	  	
	  	printf("\n \t A String: '%s' foi copiada para a String: '%s'", y, x); 	
	  	
	  }
	  
	  
	  
	void menu(){
		
	char *v1 = (char *) malloc (sizeof(char));
	char *v2 = (char *) malloc (sizeof(char));
	int *vetorInt = (int *) malloc (sizeof(int));
	char opcao = 'V';
	char triangulo;
	int a,b,c,x;
	
	while (opcao != 'D'){
		
		printf("\n \t *** OPCOES: ***\n"
				"\n  A - Execucao do Exercicio 03"
				"\n  B - Execucao do Exercicio 05 e 06"
				"\n  C - Execucao do Exercicio 07"
				"\n  D - Finalizar\n"
				"\nDigite sua opcao: ");
				
		fflush(stdin);
		scanf("%c", &opcao);
	
		
				
		switch (opcao){
		case 'A' :
			printf ("\n  -> Exercicio 03 \n");
			a = verificaRealPositivo();
			b = verificaRealPositivo();
			c = verificaRealPositivo();
			triangulo = verificarTriangulo(a,b,c);
			
			if (triangulo == 'I'){
				
				printf("\n  >Triangulo Isoceles!< \n");
			}
			
			else if (triangulo == 'S'){
				
				printf("\n  >Triangulo Escaleno!< \n");
			}
			
			else if (triangulo == 'E'){
				
				printf("\n  >Triangulo Equilatero!< \n");
			}
			
			else{
				
				printf("\n  >Triangulo Inexistente!< \n");
			}
			
			break;
			
		
		case 'B':
			printf ("\n \t\t -> Exercicio 05 e 06 \n");
			x = valida0a10();
			tabuada(x, vetorInt);
			resultTabuada(vetorInt);
			
			break;
			
		case 'C':
			printf ("\n \t\t -> Exercicio 07 \n");
			printf("\n \t Entre com a String a ser copiada: ");
			fflush(stdin);
			scanf("%s", &v2);
			
			copiaString(v1,v2);
			
			break;
				
		case 'D':
			printf("\n \t *** Programa finalizado! *** ");
			break;
		
		
		default:
			printf("\n -- Opcao invalida -- \n");
			break;
		}
	}
}

int main() {
	
	
	menu();
	return 0;
}
