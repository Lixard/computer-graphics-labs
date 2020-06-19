package ru.student.lab;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;


import static com.jogamp.opengl.GL.*;
import static com.jogamp.opengl.fixedfunc.GLLightingFunc.GL_LIGHT0;
import static com.jogamp.opengl.fixedfunc.GLLightingFunc.GL_LIGHTING;
import static com.jogamp.opengl.fixedfunc.GLMatrixFunc.GL_MODELVIEW;
import static com.jogamp.opengl.fixedfunc.GLMatrixFunc.GL_PROJECTION;
import static com.jogamp.opengl.util.ImmModeSink.GL_QUADS;

public class Renderer implements GLEventListener {
    public static GL2 gl = null;

    public float zoom = 0.0f;

    public float mouseX = 0.0f;
    public float mouseY = 0.0f;
    public float mouseZ = 0.0f;

    @Override
    public void init(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        gl.glClearColor(0,0,0,1);
        gl.glEnable(GL_DEPTH_TEST);
        gl.glEnable(GL_LIGHT0);
        gl.glEnable(GL_LIGHTING);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        gl.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL_PROJECTION);
        gl.glLoadIdentity();

        gl.glDisable(GL_BLEND);
        gl.glBegin(GL_QUADS);

        gl.glColor3f(1.0f, 1.0f, 0.0f);

        gl.glVertex3f(-0.2f, -0.25f, 0.0f);
        gl.glVertex3f(-0.2f, 0.25f, 0.0f);
        gl.glVertex3f(0.2f, 0.25f, 0.0f);
        gl.glVertex3f(0.2f, -0.25f, 0.0f);
        gl.glVertex3f(-0.2f, -0.25f, 0.1f);
        gl.glVertex3f(-0.2f, 0.25f, 0.1f);
        gl.glVertex3f(0.2f, 0.25f, 0.1f);
        gl.glVertex3f(0.2f, -0.25f, 0.1f);

        gl.glColor3f(1.0f, 1.0f, 0.2f);
        gl.glVertex3f(-0.2f, -0.25f, 0.1f);
        gl.glVertex3f(-0.2f, 0.25f, 0.1f);
        gl.glVertex3f(-0.2f, 0.25f, 0.0f);
        gl.glVertex3f(-0.2f, -0.25f, 0.0f);

        gl.glVertex3f(0.2f, -0.25f, 0.1f);
        gl.glVertex3f(0.2f, 0.25f, 0.1f);
        gl.glVertex3f(0.2f, 0.25f, 0.0f);
        gl.glVertex3f(0.2f, -0.25f, 0.0f);

        gl.glColor3f(1.0f, 1.0f, 0.2f);
        gl.glVertex3f(-0.2f, 0.25f, 0.0f);
        gl.glVertex3f(0.2f, 0.25f, 0.0f);
        gl.glVertex3f(0.2f, 0.25f, 0.1f);
        gl.glVertex3f(-0.2f, 0.25f, 0.1f);


        gl.glVertex3f(0.2f, -0.25f, 0.0f);
        gl.glVertex3f(-0.2f, -0.25f, 0.0f);
        gl.glVertex3f(-0.2f, -0.25f, 0.1f);
        gl.glVertex3f(0.2f, -0.25f, 0.1f);

        gl.glColor3f(1.0f, 0.5f, 0.0f);

        gl.glVertex3f(0.2f, -0.25f, 0.0f);
        gl.glVertex3f(-0.2f, -0.25f, 0.0f);
        gl.glVertex3f(-0.2f, -0.25f, -0.1f);
        gl.glVertex3f(0.2f, -0.25f, -0.1f);

        gl.glVertex3f(0.2f, -0.15f, 0.0f);
        gl.glVertex3f(-0.2f, -0.15f, 0.0f);
        gl.glVertex3f(-0.2f, -0.15f, -0.1f);
        gl.glVertex3f(0.2f, -0.15f, -0.1f);

        gl.glColor3f(1.0f, 0.6f, 0.0f);

        gl.glVertex3f(0.2f, -0.25f, -0.1f);
        gl.glVertex3f(0.2f, -0.15f, -0.1f);
        gl.glVertex3f(0.2f, -0.15f, 0.0f);
        gl.glVertex3f(0.2f, -0.25f, 0.0f);

        gl.glVertex3f(-0.2f, -0.25f, -0.1f);
        gl.glVertex3f(-0.2f, -0.15f, -0.1f);
        gl.glVertex3f(-0.2f, -0.15f, 0.0f);
        gl.glVertex3f(-0.2f, -0.25f, 0.0f);

        gl.glColor3f(1.0f, 0.5f, 0.2f);

        gl.glVertex3f(0.2f, -0.25f, -0.1f);
        gl.glVertex3f(-0.2f, -0.25f, -0.1f);
        gl.glVertex3f(-0.2f, -0.15f, -0.1f);
        gl.glVertex3f(0.2f, -0.15f, -0.1f);

        gl.glColor3f(0.0f, 1.0f, 0.0f);

        gl.glVertex3f(0.2f, -0.25f, -0.2f);
        gl.glVertex3f(0.2f, -0.15f, -0.2f);
        gl.glVertex3f(0.2f, -0.15f, -0.1f);
        gl.glVertex3f(0.2f, -0.25f, -0.1f);

        gl.glVertex3f(-0.2f, -0.25f, -0.2f);
        gl.glVertex3f(-0.2f, -0.15f, -0.2f);
        gl.glVertex3f(-0.2f, -0.15f, -0.1f);
        gl.glVertex3f(-0.2f, -0.25f, -0.1f);

        gl.glVertex3f(-0.1f, -0.25f, -0.1f);
        gl.glVertex3f(-0.2f, -0.25f, -0.1f);
        gl.glVertex3f(-0.2f, -0.25f, -0.2f);
        gl.glVertex3f(-0.1f, -0.25f, -0.2f);

        gl.glVertex3f(0.2f, -0.25f, -0.1f);
        gl.glVertex3f(0.1f, -0.25f, -0.1f);
        gl.glVertex3f(0.1f, -0.25f, -0.2f);
        gl.glVertex3f(0.2f, -0.25f, -0.2f);

        gl.glVertex3f(0.2f, -0.15f, -0.1f);
        gl.glVertex3f(0.1f, -0.15f, -0.1f);
        gl.glVertex3f(0.1f, -0.15f, -0.2f);
        gl.glVertex3f(0.2f, -0.15f, -0.2f);

        gl.glVertex3f(-0.1f, -0.15f, -0.1f);
        gl.glVertex3f(-0.2f, -0.15f, -0.1f);
        gl.glVertex3f(-0.2f, -0.15f, -0.2f);
        gl.glVertex3f(-0.1f, -0.15f, -0.2f);


        gl.glVertex3f(0.1f, -0.25f, -0.2f);
        gl.glVertex3f(0.1f, -0.15f, -0.2f);
        gl.glVertex3f(0.1f, -0.15f, -0.1f);
        gl.glVertex3f(0.1f, -0.25f, -0.1f);

        gl.glVertex3f(-0.1f, -0.15f, -0.2f);
        gl.glVertex3f(-0.1f, -0.25f, -0.2f);
        gl.glVertex3f(-0.1f, -0.25f, -0.1f);
        gl.glVertex3f(-0.1f, -0.15f, -0.1f);

        gl.glVertex3f(0.2f, -0.25f, -0.2f);
        gl.glVertex3f(0.1f, -0.25f, -0.2f);
        gl.glVertex3f(0.1f, -0.15f, -0.2f);
        gl.glVertex3f(0.2f, -0.15f, -0.2f);

        gl.glVertex3f(-0.2f, -0.25f, -0.2f);
        gl.glVertex3f(-0.1f, -0.25f, -0.2f);
        gl.glVertex3f(-0.1f, -0.15f, -0.2f);
        gl.glVertex3f(-0.2f, -0.15f, -0.2f);
        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        gl = drawable.getGL().getGL2();
        if (height <= 0) {
            height = 1;
        }
        gl.glViewport(0, 0,  width,  height);
        gl.glMatrixMode(GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glMatrixMode(GL_MODELVIEW);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {

    }

    public void update() {
        gl.glScalef(zoom, zoom, zoom);
        display((GLAutoDrawable) gl);
    }
}
