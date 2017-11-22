#include <gl/glut.h>

GLfloat limite = 8;
GLfloat limiteL = 8;

//metodo para desenhar
void desenha(void) {

	glClear(GL_COLOR_BUFFER_BIT); //limpar tela



	glBegin(GL_QUADS);
	glColor3f(1, 1, 1);
	glVertex2f(0.8, 0.8);
	glVertex2f(0.8, -0.8);
	glVertex2f(-0.8, -0.8);
	glVertex2f(-0.8, 0.8);
	glEnd();

	glBegin(GL_TRIANGLES);
	glColor3f(1, 0, 0);
	glVertex2f(-0.6, -0.6);
	glVertex2f(0.6, -0.6);
	glVertex2f(0, 0.6);
	glEnd();

	glBegin(GL_POLYGON);
	glColor3f(0, 1, 0);
	glVertex2f(-0.6, -0.6);
	glVertex2f(0.6, -0.6);
	glVertex2f(0.6, -0.4);
	glVertex2f(0, -0.3);
	glVertex2f(-0.6, -0.4);
	glEnd();

	glBegin(GL_LINES);
	glColor3f(0.0, 0.0, 1.0);
	glLineWidth(1);
	glVertex2f(-1.0, 1.0);
	glVertex2f(1.0, -1.0);
	glEnd();


	glFlush();
}


void teclado(int key, int x, int y) {



	if (key == GLUT_KEY_PAGE_DOWN) {

		limite--;
		glViewport(limiteL, limite, 200, 200);

	}

	if (key == GLUT_KEY_PAGE_UP) {

		limite++;
		glViewport(limiteL, limite, 200, 200);

	}


	if (key == GLUT_KEY_PAGE_LEFT) {

		limiteL--;
		glViewport(limiteL, limite, 200, 200);

	}

	if (key == GLUT_KEY_PAGE_RIGHT) {

		limiteL++;
		glViewport(limiteL, limite, 200, 200);

	}

	//reposicionar imagem

	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluOrtho2D(-limite, limite, -limite, limite);
	glutPostRedisplay();

}


//metodo inicializar 
void inicializa(void) {

	glClearColor(0.0, 0.0, 0.0, 1.0); // Preencher a tela com 0 de vermelho, 0 de verde, 0 de azul e 1 de transparencia = PRETO


	glMatrixMode(GL_PROJECTION); // modelview / projection
	glLoadIdentity();
	gluOrtho2D(-limite, limite, -limite, limite); //x e y max

	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	glViewport(0, 0, 200, 200); // iniciar imagem (x,y,largura,altura)

}

int main(void) {

	glutInitWindowSize(400.0, 400.0); //iniciar janela de 400x400
	glutInitWindowPosition(0, 0); // Posicao de onde estara a janela
	glutCreateWindow("Primeiro Exercicio"); //criar a janela
	inicializa();//chamar funcao de limpeza
	glutDisplayFunc(desenha); // essa funcao chama uma outra funcao e a execução apresenta na janela criada

	glutSpecialFunc(teclado); // ler teclas especiais

	glutMainLoop(); //espera interação do usuario ou alguma nova chamada



}
