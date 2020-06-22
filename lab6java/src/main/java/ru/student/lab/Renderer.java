package ru.student.lab;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

import static com.jogamp.opengl.GL.*;
import static com.jogamp.opengl.fixedfunc.GLMatrixFunc.GL_MODELVIEW;
import static com.jogamp.opengl.fixedfunc.GLMatrixFunc.GL_PROJECTION;

public class Renderer implements GLEventListener {

    private static GL2 gl = null;

    public float xRotationAngle = 0;
    public float yRotationAngle = 0;

    public float zoomScale = 1.0f;

    @Override
    public void init(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        gl.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        setupCamera();
        gl.glTranslatef(0, 0, -100);
        gl.glRotatef(xRotationAngle / 5, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(yRotationAngle / 5, 0.0f, 1.0f, 0.0f);
        gl.glScalef(zoomScale, zoomScale, zoomScale);
        for (float y = -480; y < 480; y += 10)
        {
            gl.glBegin(GL_LINE_STRIP);
            for (float x = -480; x < 480; x += 10)
            {
                float z= (float) ((x*x/4-y*y/8)*0.01);
                gl.glColor3f(0, 255, 255);
                gl.glVertex3f(x, y, z);
            }
            gl.glEnd();
        }
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        if (height <= 0) {
            height = 1;
        }
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glMatrixMode(GL_MODELVIEW);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {

    }

    private void setupCamera() {
        gl.glViewport(0, 0, 800, 600);
        gl.glMatrixMode(GL_PROJECTION);
        gl.glLoadIdentity();
        GLU glu = GLU.createGLU(gl);
        glu.gluPerspective(45.0f, 800/600f,0.1f, 10000.0f);
        glu.gluLookAt(
                0.0f, 0.0f, 0.1f,
                0.0f, 0.0f, 0.0f,
                0.0f, 1.0f, 0.0f
        );
        gl.glMatrixMode(GL_MODELVIEW);
        gl.glLoadIdentity();
    }
}
