#include <stdio.h>
#include <stdlib.h>


 void menu(){
 	
 	char opcao;
 	double salario;
 	int dias;
 	
 	while (opcao != 'c' || opcao != 'C')
	printf("\n\n\t A - Resultado do Exercicio 04 \n");
	printf("\n\t B - Resultado do Exercicio 05 \n");
	printf("\n\t C - Finalizar \n");
	printf("\n \t -> Digite sua opcao: ");
	
	fflush(stdin);
	scanf("%c", &opcao);
	
	switch(opcao){
		
		case 'A' || 'a':
			
			pagamento(validacao1(), &salario);
			break;
		
		case 'B' || 'b':
			
			
			break;
			
		case 'C' || 'c':
		
		  	printf("\n \t *** PROGRAMA FINALIZADO!!! ***");	
		  	break;
		  	
		default:
			
			printf("\n \t Opcao nao valida! Digite uma nova opcao: ");
			fflush (stdin);
			scanf("%c", &opcao);
			break;
		
	}
}

// valida numero inteiro, positivo ou nulo
 int validacao1(){
 		
 	int x;
  	
  	while(x < 0){
  		
  	printf("\n \t -> Digite o valor:");
  	fflush(stdin);
	scanf("%i", &x);
    
    if (x < 0){
    	
    	printf("\n \t Valor invalido! Digite novamente!");
	}
} 		
 		return(x);
	 
 
 }
 
 //validar numero real positivo
  double validacao2(){
  	
  	double y;
  	
  	printf("\n \t -> Digite o valor:");
  	fflush(stdin);
	scanf("%f", &y);
	
  	while(y <= 0){
  		
  		prinf("\n \t Valor invalido! Digite novamente!");
  		fflush (stdin);
  		scanf("%f",y);
	}  	
	
	return y;
  }

//calculo exer 4
  void pagamento(int days, double *salario){
  	
  	*salario = (30*days);
	*salario -= ( (&salario/100) * 8);
		
	}

//calculo exer 5
double mediaSalarios(double vector[n]){
	
	
	
	
}




int main() {
	


    
	return 0;
}
