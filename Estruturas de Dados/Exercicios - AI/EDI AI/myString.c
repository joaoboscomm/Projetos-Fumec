#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#define TRUE 1
#define FALSE 0
#define NOTFOUND -1

int length(char *nome){

	int tamanho;
	for(tamanho=0; *nome!='\0';tamanho++){
		nome++;
	}
	return tamanho;
}

int equals(char* str1, char* str2){
	
    return TRUE ?!strcmp(str1, str2) : FALSE;
    
}

int equalsIgnoreCase(char* str1, char* str2){
	
    if (length(str1) != length(str2)){
    	
        return FALSE;
    }
    
    while(*str1 != '\0'){
    	
        if (tolower(*str1) != tolower(*str2)){
        	
            return FALSE;
        }
        
        str1++;
        str2++;
    }
    
    return TRUE;
}

char* substring(char* str1, int ini, int fim){
	
    char* sub = (char*)malloc(sizeof((fim - ini) + 1));
    int i,j;
    
    for (i = ini,j=0; i < fim; ++i, j++) {
    	
        sub[j] = str1[i];
        
    }
    
    sub[fim - ini] = '\0';
    return sub;
}

void replace(char* str, char o, char c){
	
    while(*str != '\0'){
    	
        if (*str == o){
            *str = c;
        }
        
        str++;
        
    }
}

int firstIndexOf(char *frase,char i){
	
	char *aux = frase;
    int index = 0;
    
    while(*aux != '\0'){
    	
        if(*aux == i){
        	
            return index;
            
        }
        
        index++;
        aux++;
    }
    
    return -1;
}

int lastIndexOf(char *frase, char i){
	
    char* pch = strrchr(frase, i);
    
    if (pch == NULL) {
    	
        return NOTFOUND;
        
    }
    
    return pch - frase;
}

void toUpperCase(char * string){
	
	int tamanho, i;
	tamanho = length(string);
	
	for (i = 0; i < tamanho; i++){
		
		if ((*string >= 97) && (*string <= 122)){
			
		*string = *string - 32;
		
		}
		
		string++;
	}
}

void toLowerCase(char * string){
	
	int tamanho, i;
	tamanho = length(string);

	for (i = 0; i < tamanho; i++){
		
		if ((*string >=65) && (*string <=90)){
			
		*string = *string + 32;
		string++;
		
		}
	}
}
