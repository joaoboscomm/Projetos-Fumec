#include "myString.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
// colocar o restante dos includes

typedef struct {
	char nome [200];
  	char endereco [200];
  	char dtNasc [11];
  	int sequencial;
  	char matricula[8];
}Usuario;
void menuPrincipal(int tam);

void cadastroAluno(Usuario* lista, int indice);
int camposVazios(char *campos);
int validarData (char *data);
void pesquisarSobreNome (Usuario *user, int tam);
//char gerarCod(Usuario *user, int tam);
void pesquisarAnoNasc (Usuario *user, int tam);
void pesquisarMesNasc (Usuario *user, int tam);
void pesquisarMatricula (Usuario *user, int tam);
void listarUsuarios(Usuario *user, int tam);
#ifndef WINDOWS
#define WINDOWS
#endif
