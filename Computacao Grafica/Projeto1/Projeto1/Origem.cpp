#include <gl/glut.h>

//metodo para desenhar
void desenha(void) {

	glClear(GL_COLOR_BUFFER_BIT); //limpar tela
	glColor3f(0.0, 0.0, 1.0);//setar vermelho 3f = 3flots

	/*glCOlor3f(0.0, 1.0, 0.0);  verde
	glCOlor3f(0.0, 0.0, 1.0); azul*/

	glLineWidth(1);//setar linha em px
	glBegin(GL_LINES);// desenhar uma linha no inicio 

	// glCOlor3f(0.0, 1.0, 0.0) - colocando antes do vertice o vertice assume essa cor
	glVertex2f(-1.0, 1.0); //primeiro vertice do desenho - 2f = 2 floats
	glVertex2f(1.0, -1.0);  // segundo vertice do desenho - 2f = 2 floats

	glEnd(); //final do desenho

		glFlush(); //finalizou e printa a imagem
}

//metodo inicializar 
void inicializa(void) {

	glClearColor(0.0, 0.0, 0.0,1.0); // Preencher a tela com 0 de vermelho, 0 de verde, 0 de azul e 1 de transparencia = PRETO
	
}

int main(void) {

	glutInitWindowSize(400.0, 400.0); //iniciar janela de 400x400
	glutInitWindowPosition(0, 0); // Posicao de onde estara a janela
	glutCreateWindow("Primeiro Exercicio"); //criar a janela
	inicializa();//chamar funcao de limpeza
	glutDisplayFunc(desenha); // essa funcao chama uma outra funcao e a execução apresenta na janela criada
	glutMainLoop(); //espera interação do usuario ou alguma nova chamada



}