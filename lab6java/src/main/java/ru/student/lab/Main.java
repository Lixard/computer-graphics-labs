package ru.student.lab;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;

public class Main {
    public static void main(String[] args) {
        GLProfile.initSingleton();
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);

        GLWindow window = GLWindow.create(caps);
        window.setSize(640, 480);
        Renderer renderer = new Renderer();
        window.addGLEventListener(renderer);
        window.addMouseListener(new RotationAndZoomMouseListener(renderer));
        FPSAnimator animator = new FPSAnimator(window, 60);
        animator.start();
        window.setVisible(true);
    }
}
