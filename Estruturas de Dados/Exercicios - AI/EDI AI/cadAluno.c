#include "cadAluno.h"


int main(){
    int tamanho;

    printf("\n \tInforme a quantidade de alunos a ser cadastrados:\n");
    scanf("%d", &tamanho);

    menuPrincipal(tamanho);
    system("cls");

    return 0;
}

void menuPrincipal(int tam){
    Usuario* p_listaUsuario = (Usuario*) malloc(tam*sizeof(Usuario));
    int op, x = 0; //op = op

    do{
        system("cls");
        printf("\n*******************************************");
        printf("\n      1 - CADASTRAR USUARIO                ");
        printf("\n      2 - PESQUISAR SOBRENOME              ");
        printf("\n      3 - PESQUISAR MES NASCIMENTO         ");
        printf("\n      4 - PESQUISAR ANO NASCIMENTO         ");
        printf("\n      5 - PESQUISAR MATRICULA              ");
        printf("\n      6 - LISTAR ALUNOS                    ");
        printf("\n      0 - SAIR                             ");
        printf("\n*******************************************");

        printf("\n\t ESCOLHA UMA OPCAO: ");
        scanf("%d", &op);
        fflush(stdin);

        switch(op){
            case 0 : break;
            case 1 :
                     if(x < tam){
                         cadastroAluno(p_listaUsuario, x);
                         x++;
                     }else{
                         printf("\n \t Lista cheia!");
                     }
                     break;
            case 2 :
                     pesquisarSobreNome (p_listaUsuario, x);
                     break;
            case 3:
                     pesquisarMesNasc(p_listaUsuario, x);
                     break;
            case 4:
                     pesquisarAnoNasc(p_listaUsuario, x);
                     break;
            case 5:
                     pesquisarMatricula(p_listaUsuario, x);
                     break;
            case 6:
                     listarUsuarios(p_listaUsuario, x);
                     break;
            default:
                     fflush(stdin);
                     printf("\n\t Opcao invalida! Informe uma opcao valida:");
                     break;

        }//fim switch
        system("pause");
    }while (op !=0);
    free(p_listaUsuario);
}

void cadastroAluno(Usuario* lista, int indice){
    Usuario user;
    int i, x, y,j;
    int verdadeiro;
    Biblioteca str = new;

    printf("\n\t ***** CADASTRO ***** ");

    do{
        verdadeiro = 1;

        printf("\n \t Informe o nome e sobrenome do aluno:");
        fflush(stdin);
        gets(user.nome);
        //scanf("%s", &user->nome );
        //printf("%s", user->nome );

        verdadeiro = !camposVazios(user.nome);

        if(!verdadeiro){
            printf("\n \t O nome não foi preenchido!");
        }

    }while(!verdadeiro);

    do {
    	
    	// realizar validações separadas inves de virgulas
    	
        verdadeiro = 1;
        printf("\n \t Informe o endereco e numero (Separandos por virgula (,))\n");
        fflush(stdin);
        gets(user.endereco);

        if(camposVazios(user.endereco)) {
            printf("\nAtencao! O endereco deve ser preenchido!\n");
            verdadeiro = 0;
        }

        y = str.firstIndexOf(user.endereco, ',');

        if(y <= 0) {
            printf("\nAtencao! Endereco e numero devem ser separados por virgula\n");
            verdadeiro = 0;
        }


    }while(!verdadeiro);

    do{
        printf("\nInforme a DATA de NASCIMENTO do aluno: (DD/MM/AAAA)\n");
        fflush(stdin);
        gets(user.dtNasc);
        //printf("%s", user->dtNasc);
        x = validarData(user.dtNasc);
    } while (x==1);

    //gerar matricula
    y = str.lastIndexOf(user.nome, '\0');
    user.matricula[0] = user.nome[0];
    user.matricula[1] = user.nome[y-1];
    user.matricula[2] = user.dtNasc[6];
    user.matricula[3] = user.dtNasc[7];
    user.matricula[4] = user.dtNasc[8];
    user.matricula[5] = user.dtNasc[9];
    sprintf(user.matricula + 6, "%d", indice+1);

    printf("\n Matricula do aluno: %s\n", user.matricula);
    lista[indice] = user;
}

int camposVazios(char *campos) {
    int i = 0;
    char *auxiliar1;

    auxiliar1 = campos;
    for(i = 0; *(auxiliar1) != '\0'; i++) {
        if(*(auxiliar1) != ' ') {
            //printf("%c", *auxiliar1);
            return 0;
        }
        auxiliar1++;
    }
    return 1;
}

int validarData (char *data){

    int dia, mes, ano;
    int i;
    char *data_aux;
    char *fimPonteiro;
    char *aux_mes;
    char * aux_ano;

    data_aux = data;

    if ((length(data_aux) != 10) || (equalsIgnoreCase(data_aux," ")) ==1){
        return 1;
        data_aux = data_aux+2;
    }

    else if ((equalsIgnoreCase(data,"/")) == 1){
        printf("parou aqui 2 - equals /");
        return 1;
        data_aux = data;
        data_aux = data +5;
    }
    else if ((equalsIgnoreCase(data,"/")) ==1) {
        printf("parou aqui 3 - equals /");
        return 1;
    }

    data_aux = data;
    substring(data_aux,0,2);
    dia = strtol(data_aux, &fimPonteiro,10);

    aux_mes = substring(data_aux,3,4);
    mes = strtol(aux_mes, &fimPonteiro,10);

    aux_ano = substring(data_aux,6,10);
    ano = strtol(aux_ano, &fimPonteiro,10);

    if (dia < 0 || dia >31){
        return 1;
    }

    if ((mes < 0) ||(mes > 12)){
        return 1;
    }

    if (ano < 1900 || ano > 2016){
        return 1;
    }

    if ((dia >= 0 && dia <= 31) && (mes >= 0 && mes <= 12) && (ano >= 1900 && ano <= 2016)){
        if ((dia == 29 && mes == 2) && ((ano % 4) == 0)){
            return 1;
        }
        if (dia > 28 && mes == 2){
            return 1;
        }
        if ((dia > 30) && (mes == 4 || mes == 6 || mes == 9 || mes == 11)){
            return 1;
        }
        if ((dia >31) && (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes ==8 || mes == 10 || mes == 12)){
            return 1;
        }
        else
        {
            return 0;
        }
    }
}


void pesquisarSobreNome (Usuario *user, int tam){
    char sobrenome1 [101];
    char sobrenomeInformado [101];
    int y, i;
    Biblioteca str = new

    printf("\nInforme o SOBRENOME:\n");
    fflush(stdin);
    gets(sobrenomeInformado);

    for (i=0; i< tam; i++){
        y = str.lastIndexOf((*user).nome, ' ');
        strcpy(sobrenome1, str.substring((*user).nome, (y + 1), length((*user).nome))) ;
        if (str.equalsIgnoreCase(sobrenome1,sobrenomeInformado)){

		printf("\nnome: %s", (*user).nome);
		printf("\nendereco: %s", (*user).endereco);
		printf("\ndata nasc.: %s",(*user).dtNasc);
		printf("\nmatricula: %s\n",(*user).matricula);
            return;
        }
        user++;
    }
    printf("\n\nUsuario nao encontrado\n\n!");
}

/*
   char gerarMatricula(Usuario *user, int tam){
   Usuario *auxiliar;
   auxiliar = user;
   char *matricula [8];
   int i, y;
   Biblioteca str = new;

   for(i = 0; i < tam; i++){
   y = str.lastIndexOf((*auxiliar).nome, '/0' - 1);
   matricula[0] = (*auxiliar).nome[0];
   matricula[1] = (*auxiliar).nome[y];
   matricula[2] = (*auxiliar).dtNasc[6];
   matricula[3] = (*auxiliar).dtNasc[7];
   matricula[4] = (*auxiliar).dtNasc[8];
   matricula[5] = (*auxiliar).dtNasc[9];
   matricula[6] = (*auxiliar).sequencial[0];
   auxiliar++;
   }
   return matricula;

   }
   */

void pesquisarMesNasc (Usuario *user, int tam){
    char mes[3];
    char mesBusca[3];
    int y = 0, i;
    int achou = 0;
    Biblioteca str = new

    printf("\nInforme o MES DE NASCIMENTO: \n");
    scanf("%s", mesBusca);

    for (i=0; i< tam; i++){
        y = str.firstIndexOf((*user).dtNasc, '/' );
        strcpy(mes, str.substring((*user).dtNasc, (y + 1), (y + 3))) ;
        if (str.equals(mes,mesBusca)){

		printf("\nnome: %s", (*user).nome);
		printf("\nendereco: %s", (*user).endereco);
		printf("\ndata nasc.: %s",(*user).dtNasc);
		printf("\nmatricula: %s\n",(*user).matricula);
            achou = 1;
        }
        user++;
    }
    if(!achou){
        printf("Usuario nao encontrado\n\n!");
    }
}

void pesquisarAnoNasc (Usuario *user, int tam){
    char ano[4];
    char anoBusca[4];
    int y = 0, i;
    int achou = 0;
    Biblioteca str = new

    printf("\nInforme o ANO DE NASCIMENTO: \n");
    scanf("%s", anoBusca);

    for (i=0; i< tam; i++){
        y = str.lastIndexOf((*user).dtNasc, '/' );
        strcpy(ano, str.substring((*user).dtNasc, (y + 1), length((*user).dtNasc)));
        
        if (str.equals(ano,anoBusca)){

		printf("\nnome: %s", (*user).nome);
		printf("\nendereco: %s", (*user).endereco);
		printf("\ndata nasc.: %s",(*user).dtNasc);
		printf("\nmatricula: %s\n",(*user).matricula);
            achou = 1;
        }
        user++;
    }
    if(!achou){
        printf("Usuario nao encontrado\n\n!");
    }
}


void pesquisarMatricula (Usuario *user, int tam){
    char matriculaBusca [8];
    int y, i;
    Biblioteca str = new

    printf("\nInforme o MATRICULA:\n");
    scanf("%s",matriculaBusca);

    for (i=0; i< tam; i++){

		if (str.equalsIgnoreCase((*user).matricula,matriculaBusca)){	
		printf("\nnome: %s", (*user).nome);
		printf("\nendereco: %s", (*user).endereco);
		printf("\ndata nasc.: %s",(*user).dtNasc);
		printf("\nmatricula: %s\n",(*user).matricula);
		
            return;
        }
        user++;
    }
    printf("\n\nUsuario nao encontrado\n\n!");
}

void listarUsuarios(Usuario *user, int tam){
	Usuario *auxiliar;
	auxiliar = user;
	int i;
	for (i=0; i<tam; i++){
		printf("\nnome: %s", (*auxiliar).nome);
		printf("\nendereco: %s", (*auxiliar).endereco);
		printf("\ndata nasc.: %s",(*auxiliar).dtNasc);
		printf("\nmatricula: %s\n",(*auxiliar).matricula);
		auxiliar++;
	}
}
