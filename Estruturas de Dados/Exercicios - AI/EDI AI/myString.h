#include "myString.c"
// #ifndef STRING
//	#define STRING

int length(char *nome);
int firstIndexOf(char *frase,char i);
int lastIndexOf(char *frase,char i);
int equals(char *string, char *string_aux);
void toUpperCase(char * string);
void toLowerCase(char * string);
void replace(char* str, char o, char c);
char *substring(char *nome, int posInicial, int posFinal);
int equalsIgnoreCase(char* str1, char* str2);

typedef struct {
    int   (*length)(char*);
    int   (*equals)(char*, char*);
    int   (*equalsIgnoreCase)(char*, char*);
    char* (*substring)(char*, int, int);
    void  (*toUpperCase)(char*);
    void  (*toLowerCase)(char*);
    void  (*replace)(char*, char, char);
    int   (*lastIndexOf)(char*, char);
    int   (*firstIndexOf)(char*, char);

}Biblioteca;

#ifndef new
#define new {.length=length, .equals=equals, .equalsIgnoreCase=equalsIgnoreCase, .substring=substring,.toUpperCase=toUpperCase, .toLowerCase=toLowerCase, .replace=replace, .lastIndexOf=lastIndexOf, .firstIndexOf=firstIndexOf};
#endif
