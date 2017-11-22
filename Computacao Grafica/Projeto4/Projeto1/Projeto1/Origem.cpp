#include <GL/glut.h>
#include <stdlib.h>

void DesenhaQuadro(void)
{
	
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	glPushMatrix();

	glTranslatef(0, -5, 0);
	glColor3f(1.0, 1.0, 1.0);
	glBegin(GL_QUADS);
	glVertex2f(-8.0, 8.0);
	glVertex2f(8.0, 8.0);
	glVertex2f(8.0, -8.0);
	glVertex2f(-8.0, -8.0);
	glEnd();

	glPopMatrix();

	glPushMatrix();


	glRotatef(45.0f, 0.0f, 0.0f, 1.0f);

	glColor3f(1.0, 0.0, 0.0);
	glBegin(GL_TRIANGLES);
	glVertex2f(-6.0, -6.0);
	glVertex2f(0.0, 6.0);
	glVertex2f(6.0, -6.0);
	glEnd();

	glColor3f(0.0, 1.0, 0.0);
	glBegin(GL_POLYGON);
	glVertex2f(-6.0, -4.0);
	glVertex2f(0.0, -3.0);
	glVertex2f(6.0, -4.0);
	glVertex2f(6.0, -6.0);
	glVertex2f(-6.0, -6.0);
	glEnd();

	glPopMatrix();

	glColor3f(0.0, 0.0, 1.0);
	glLineWidth(2.0);
	glBegin(GL_LINES);
	glVertex2f(-10.0, 10.0);
	glVertex2f(10.0, -10.0);
	glEnd();
}

	void Desenha(void)
	{
		glClear(GL_COLOR_BUFFER_BIT);
		glViewport(0, 0, 400, 400);
		DesenhaQuadro();
	}

	void Anima(int)
	{


		if (deslocaX > 20)
		{
			deslocaX = -10;
		}

		deslocaX += 1;
		glutPostRedisplay();
		glutTimerFunc(150, Anima, 1);

	}
	
	int main(void)
	{
		
		Anima(1);
		glutMainLoop();
	}


