#include <stdio.h>
#include <stdlib.h>


	int vetor[] = {60,14,-49,8,-27,5,98,7,32,40};
	int *ponteiro = vetor;
	int *ponteiroInicio;
	int tamanho = sizeof(vetor);
	double media = 0;
	int menor = *ponteiro;
	int negativos = 0;
		
	
	int menorElemento(){
			
		for(int i=0;i < tamanho; i++){
			
			if(*ponteiro < menor){
				
				menor = *ponteiro;
			}
						
			ponteiro++;
		}
		
		*ponteiro = *ponteiroInicio;
		
		return (menor);
	}
	
	int numerosNegativos(){
	
	for(int i=0; i < tamanho ; i++){
		
			if(*ponteiro < 0){
				negativos +=1;
			}
			
			
	}
	
	*ponteiro = *ponteiroInicio;
 	return (negativos);
 	
}
				
		void printarInvertido(){
			
			ponteiro += tamanho -1; //vai para a ultima posicao do vetor
					
		for(int i=0; i < tamanho ; i++){
			
			printf("%d\n", *ponteiro);
			
			ponteiro--;
		}
		
		*ponteiro = *ponteiroInicio;
	}
	

	
	double calculaMedia(){
	
		
			
			for(int i=0;i < tamanho; i++){
			
			media += *ponteiro;
			ponteiro++;
		
		}
		
		*ponteiro = *ponteiroInicio;
		return(media/tamanho);
	}
		
	
	int main() {
		
		
		printf("O menor elemento e: %d \n", menorElemento());
		printf("A media e: %d \n", calculaMedia());
		printf("Valores negativos: %d\n", numerosNegativos());
		printf("Imprimindo em ordem invertida: \n");
		printarInvertido();
	
		
		
	
	return 0;
}
